package com.mt.mybatis.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * <p>拦截器链，这里规定只对executor方法进行拦截增强</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtInterceptorChain {
    private List<MtInterceptor> interceptors = new ArrayList();

    public void addInterceptor(MtInterceptor interceptor) {
        this.interceptors.add(interceptor);
    }

    public List<MtInterceptor> getInterceptors() {
        return Collections.unmodifiableList(this.interceptors);
    }

    public Object pluginAll(Object target){
        for(MtInterceptor var1 : interceptors){
            target = var1.plugin(target);
        }
        return target;
    }



}
