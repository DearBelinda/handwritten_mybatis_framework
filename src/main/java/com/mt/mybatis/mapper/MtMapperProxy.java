package com.mt.mybatis.mapper;

import com.mt.mybatis.session.MtSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>MapperProxy，模拟mybatis的mapper代理对象</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtMapperProxy implements InvocationHandler {
    private MtSqlSession mtSqlSession;
    private Class mapperInterface;

    public MtMapperProxy(MtSqlSession mtSqlSession, Class mapperInterface) {
        this.mtSqlSession = mtSqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperData mapperData = this.mtSqlSession.getConfiguration().getMapperRegistory().getMethodSqlMapping().get(mapperInterface.getName()+"."+method.getName());
        if(mapperData!=null){
            return this.mtSqlSession.selectOne(mapperData,args);
        }
        return method.invoke(proxy,args);
    }

}
