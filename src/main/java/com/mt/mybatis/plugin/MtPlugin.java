package com.mt.mybatis.plugin;

import com.mt.mybatis.executor.MtExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>Plugin 代理实现类</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtPlugin implements InvocationHandler {
    private Object target;
    private MtInterceptor interceptor;

    public MtPlugin(Object target, MtInterceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return this.interceptor.intercept(new MtInvocation(target,method,args));
    }

    public static Object wrap(Object target,MtInterceptor interceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{MtExecutor.class},new MtPlugin(target,interceptor));
    }
}
