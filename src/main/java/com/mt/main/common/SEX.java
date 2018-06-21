package com.mt.main.common;

/**
 * <p>性别枚举类型</p>
 *
 * @author grand 2018/6/21
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public enum SEX {
    MALE("男",1),
    FEMALE("女",0);

    SEX(String sexName, Integer sexType){
        this.sexName = sexName;
        this.sexType = sexType;
    }

     private String sexName;
     private Integer sexType;

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Integer getSexType() {
        return sexType;
    }

    public void setSexType(Integer sexType) {
        this.sexType = sexType;
    }

    @Override
    public String toString() {
        return "SEX{" +
                "sexName='" + sexName + '\'' +
                ", sexType=" + sexType +
                '}';
    }
}
