package com.mt.mybatis.session;

import com.mt.mybatis.configuration.MtConfiguation;
import com.mt.mybatis.executor.MtExecutor;

/**
 * <p>SqlSessionFactory </p>
 *
 * @author suhongwei 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSqlSessionFactory {
    private MtConfiguation configuation;
    private MtExecutor executor;

    public MtSqlSessionFactory(MtConfiguation configuation,MtExecutor executor) {
        this.configuation = configuation;
        this.executor = executor;
    }

    public MtSqlSession openSession() {
        return new MtSqlSession(configuation,executor);
    }
}
