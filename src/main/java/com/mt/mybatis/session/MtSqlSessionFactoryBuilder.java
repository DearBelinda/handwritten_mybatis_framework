package com.mt.mybatis.session;

import com.mt.mybatis.configuration.MtConfiguration;

/**
 * <p>SqlSessionFactoryBuilder</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSqlSessionFactoryBuilder {
    private MtConfiguration configuation;

    public MtSqlSessionFactoryBuilder(MtConfiguration configuation){
        this.configuation = configuation;
    }

    public MtSqlSessionFactory build(){
        return new MtSqlSessionFactory(configuation);
    }



}
