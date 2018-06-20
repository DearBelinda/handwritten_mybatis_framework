package com.mt.mybatis.executor;

import com.mt.mybatis.configuration.MtConfiguation;
import com.mt.mybatis.mapper.MapperData;
import com.mt.mybatis.statement.StatementHandler;

/**
 * <p></p>
 *
 * @author suhongwei 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtSimpleExecutor implements MtExecutor {
    private MtConfiguation configuation;

    public MtSimpleExecutor(MtConfiguation configuation){
        this.configuation = configuation;
    }

    @Override
    public <T> T query(MapperData mapperData, Object parameter) throws Exception {
        StatementHandler statementHandler = new StatementHandler(configuation);
        return statementHandler.query(mapperData,parameter);
    }
}
