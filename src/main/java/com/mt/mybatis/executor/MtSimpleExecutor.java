package com.mt.mybatis.executor;

import com.mt.mybatis.configuration.MtConfiguration;
import com.mt.mybatis.mapper.MapperData;
import com.mt.mybatis.statement.StatementHandler;

/**
 * <p>SimpleExecutor，执行器类的一种简单实现</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSimpleExecutor implements MtExecutor {
    private MtConfiguration configuation;

    public MtSimpleExecutor(MtConfiguration configuation){
        this.configuation = configuation;
    }

    @Override
    public <T> T query(MapperData mapperData, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuation);
        return statementHandler.query(mapperData,parameter);
    }
}
