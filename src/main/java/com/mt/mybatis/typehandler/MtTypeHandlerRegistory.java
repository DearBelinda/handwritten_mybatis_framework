package com.mt.mybatis.typehandler;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>TypeHandlerRegistory</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtTypeHandlerRegistory {
    public static Map<Type,MtTypeHandler> TYPE_HANDLER_MAP = new ConcurrentHashMap();

    public void regist(MtTypeHandler typeHandler) throws IllegalAccessException, InstantiationException {
        TYPE_HANDLER_MAP.put(typeHandler.getJavaType(),typeHandler);
    }

}
