package com.mt.mybatis.statement;

import com.mt.mybatis.configuration.MtConfiguation;
import com.mt.mybatis.configuration.MtDataSource;
import com.mt.mybatis.mapper.MapperData;
import com.mt.mybatis.parameter.ParameterHandler;
import com.mt.mybatis.result.ResultHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * <p>StatementHandler</p>
 *
 * @author suhongwei 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class StatementHandler {
    private MtConfiguation configuation;

    public StatementHandler(MtConfiguation configuation){
        this.configuation = configuation;
    }

    public <E> E query(MapperData mapperData, Object parameter){
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(mapperData.getSql());
            ParameterHandler parameterHandler = new ParameterHandler(preparedStatement);
            parameterHandler.setParameters(parameter);
            preparedStatement.execute();
            ResultHandler resultHandler = new ResultHandler(mapperData.getType(),preparedStatement.getResultSet());
            return (E) resultHandler.handle();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        MtDataSource dataSource = configuation.getDataSource();
        Class.forName(dataSource.getDriver());
        return DriverManager.getConnection(dataSource.getUrl(),dataSource.getUserName(),dataSource.getPassWord());
    }
}
