package com.mt.mybatis.result;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p></p>
 *
 * @author suhongwei 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class ResultHandler {
    private Class type;
    private ResultSet resultSet;

    public ResultHandler(Class type, ResultSet resultSet){
        this.type = type;
        this.resultSet = resultSet;
    }

    public <E> E handle() throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object resultObject = new DefaultObjectFactory().create(type);
        if(resultSet.next()){
            for(Field field:resultObject.getClass().getDeclaredFields()){
                setValue(resultObject,field,resultSet);
            }
        }
        return (E) resultObject;
    }

    public void setValue( Object resultObject,Field field,ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        Method method = type.getMethod("set"+upperCapital(field.getName()),field.getType());
        method.invoke(resultObject,getResult(field,resultSet));
    }

    public Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        if(Integer.class == type){
            return rs.getInt(field.getName());
        }else if(String.class == type){
            return rs.getString(field.getName());
        }else if(Long.class == type){
            return rs.getLong(field.getName());
        }else{
            return rs.getString(field.getName());
        }
    }

    private String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }


}
