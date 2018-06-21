package com.mt.mybatis.mapper;

/**
 * <p>模拟mapper.xml解析后的简单封装</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MapperData {
    private String sql;
    private Class type;

    public MapperData(String sql, Class type) {
        this.sql = sql;
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MapperData{" +
                "sql='" + sql + '\'' +
                ", resultType=" + type +
                '}';
    }
}
