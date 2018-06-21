package com.mt.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>TypeHandler，顶层类型处理器接口，用于定义类型处理的行为</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public interface MtTypeHandler<T> {
    void setParameter(PreparedStatement var1, int var2, T var3, JdbcType var4) throws SQLException;

    T getResult(ResultSet var1, String var2) throws SQLException;

    T getResult(ResultSet var1, int var2) throws SQLException;

    Type getJavaType();
}
