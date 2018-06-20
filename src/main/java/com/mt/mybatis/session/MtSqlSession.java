package com.mt.mybatis.session;

import com.mt.mybatis.configuration.MtConfiguation;
import com.mt.mybatis.executor.MtExecutor;
import com.mt.mybatis.mapper.MapperData;
import com.mt.mybatis.mapper.MtMapperProxy;

import java.lang.reflect.Proxy;

/**
 * <p>SqlSession</p>
 *
 * @author suhongwei 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSqlSession {
    private MtConfiguation configuration;
    private MtExecutor executor;

    public MtSqlSession(MtConfiguation configuration,MtExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MtMapperProxy(this,clazz));
    }

    public <T> T selectOne(MapperData mapperData, Object parameter) throws Exception {
        return executor.query(mapperData, parameter);
    }

    public MtConfiguation getConfiguration() {
        return configuration;
    }
}
