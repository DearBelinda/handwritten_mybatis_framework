package com.mt.mybatis.session;

import com.mt.mybatis.configuration.MtConfiguation;
import com.mt.mybatis.executor.ExecutorType;
import com.mt.mybatis.executor.MtExecutor;

/**
 * <p>SqlSessionFactory，会话工厂 </p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSqlSessionFactory {
    private MtConfiguation configuration;

    public MtSqlSessionFactory(MtConfiguation configuration) {
        this.configuration = configuration;
    }

    public MtSqlSession openSession() {
        return openSessionFromDataSource(ExecutorType.SIMPLE);
    }

    private MtSqlSession openSessionFromDataSource(ExecutorType execType) {
        MtExecutor executor = this.configuration.newExecutor(execType);
        MtSqlSession sqlSession = new MtSqlSession(configuration, executor);
        return sqlSession;
    }
}
