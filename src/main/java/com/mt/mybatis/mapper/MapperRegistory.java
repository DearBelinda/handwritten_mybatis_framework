package com.mt.mybatis.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p></p>
 *
 * @author suhongwei 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MapperRegistory {
    private Logger logger = LoggerFactory.getLogger(MapperRegistory.class);
    private Map<String,MapperData> methodSqlMapping = new HashMap<>();

    public void doLoadMethodSqlMapping(Properties mapperProperties) throws ClassNotFoundException {
        Enumeration propertyNames = mapperProperties.propertyNames();
        while(propertyNames.hasMoreElements()){
            String key = (String)propertyNames.nextElement();
            String value = mapperProperties.getProperty(key);
            String sql = value.substring(0,value.indexOf("#"));
            String t = value.substring(value.indexOf("#")+1,value.length());
            Class type = this.getClass().getClassLoader().loadClass(t);
            this.methodSqlMapping.put(key,new MapperData(sql,type));
            logger.info("In loading methodSqlMapping------sql: "+sql+" and type: "+type);
        }
    }

    public Map<String, MapperData> getMethodSqlMapping() {
        return methodSqlMapping;
    }
}
