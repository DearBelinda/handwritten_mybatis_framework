package com.mt.main.plugin;

import com.mt.mybatis.mapper.MapperData;
import com.mt.mybatis.plugin.MtInterceptor;
import com.mt.mybatis.plugin.MtInvocation;
import com.mt.mybatis.plugin.MtPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>执行日志输出插件</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class ExecutorLogPlugin implements MtInterceptor {
    private final Logger logger = LoggerFactory.getLogger(ExecutorLogPlugin.class);


    @Override
    public Object intercept(MtInvocation invocation) throws Throwable {
        MapperData mapperData = (MapperData)invocation.getArgs()[0];
        Object[] parameter = (Object[])invocation.getArgs()[1];
        logger.info("ExecutorLogPlugin is in processing....");
        logger.info("mapperData is :"+ mapperData);
        for (int i=0;i<parameter.length;i++) {
            logger.info("parameter "+ i +" is　:" + parameter[i]);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object var1) {
        return MtPlugin.wrap(var1,this);
    }
}
