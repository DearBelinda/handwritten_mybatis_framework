package com.mt.mybatis.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <p>ParameterHandler,参数处理器</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class ParameterHandler {
    private PreparedStatement psmt;

    public ParameterHandler(PreparedStatement statement){
        this.psmt = statement;
    }

    public void setParameters(Object parameter){
        try{
            Object[] parameters = (Object[])parameter;
            for (int i = 0;i<parameters.length;i++) {
                if(parameters[i] instanceof Integer){
                    psmt.setInt(i+1,(Integer)parameters[i]);
                }else if(parameters[i] instanceof Long){
                    psmt.setLong(i+1,(Long)parameters[i]);
                }else if(parameters[i] instanceof String){
                    psmt.setString(i+1,String.valueOf(parameters[i]));
                }else if(parameters[i] instanceof Boolean){
                    psmt.setBoolean(i+1,(Boolean)parameters[i]);
                }else{
                    psmt.setString(i+1,String.valueOf(parameters[i]));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
