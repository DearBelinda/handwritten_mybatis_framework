package com.mt.mybatis.session;

import com.mt.mybatis.configuration.MtConfiguation;
import com.mt.mybatis.executor.MtExecutor;
import com.mt.mybatis.executor.MtSimpleExecutor;

/**
 * <p></p>
 *
 * @author suhongwei 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSqlSessionFactoryBuilder {
    private MtConfiguation configuation;

    public MtSqlSessionFactoryBuilder(MtConfiguation configuation){
        this.configuation = configuation;
    }

    public MtSqlSessionFactory build(){
        return new MtSqlSessionFactory(configuation);
    }



}
