package com.mt.mybatis.executor;

/**
 * <p>executor 类型</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public enum ExecutorType {
    SIMPLE,
    REUSE,
    BATCH;

    private ExecutorType() {
    }
}
