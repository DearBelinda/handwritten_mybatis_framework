package com.mt.mybatis.statement;

import com.mt.mybatis.configuration.MtConfiguration;
import com.mt.mybatis.configuration.MtDataSource;
import com.mt.mybatis.mapper.MapperData;
import com.mt.mybatis.parameter.ParameterHandler;
import com.mt.mybatis.result.ResultHandler;

import java.sql.*;

/**
 * <p>StatementHandler，语句集处理</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class StatementHandler {
    private MtConfiguration configuation;

    public StatementHandler(MtConfiguration configuation){
        this.configuation = configuation;
    }

    public <E> E query(MapperData mapperData, Object parameter){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(mapperData.getSql());
            ParameterHandler parameterHandler = new ParameterHandler(preparedStatement);
            parameterHandler.setParameters(parameter);
            preparedStatement.execute();
            ResultHandler resultHandler = new ResultHandler(mapperData.getType(),preparedStatement.getResultSet());
            return (E) resultHandler.handle();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        MtDataSource dataSource = configuation.getDataSource();
        Class.forName(dataSource.getDriver());
        return DriverManager.getConnection(dataSource.getUrl(),dataSource.getUserName(),dataSource.getPassWord());
    }
}
