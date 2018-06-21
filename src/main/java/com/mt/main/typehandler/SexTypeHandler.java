package com.mt.main.typehandler;

import com.mt.main.common.SEX;
import com.mt.mybatis.typehandler.MtTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>性别类型转换器</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class SexTypeHandler implements MtTypeHandler<SEX> {
    private static final Logger logger = LoggerFactory.getLogger(SexTypeHandler.class);


    @Override
    public void setParameter(PreparedStatement var1, int var2, SEX var3, JdbcType var4) throws SQLException {

    }

    @Override
    public SEX getResult(ResultSet var1, String var2) throws SQLException {
        logger.info("SexTypeHandler is in processing...");
        if(SEX.MALE.getSexType().equals(var1.getInt(var2))){
            return SEX.MALE;
        }else{
            return SEX.FEMALE;
        }
    }

    @Override
    public SEX getResult(ResultSet var1, int var2) throws SQLException {
        return null;
    }

    @Override
    public Type getJavaType() {
        return ((ParameterizedType)this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }
}
