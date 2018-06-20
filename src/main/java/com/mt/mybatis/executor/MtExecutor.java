package com.mt.mybatis.executor;

import com.mt.mybatis.mapper.MapperData;

/**
 * <p>Executor,sql执行的顶层接口</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public interface MtExecutor {

    <T> T query(MapperData mapperData, Object parameter) throws Exception;
}
