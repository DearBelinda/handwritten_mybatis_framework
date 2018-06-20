package com.mt.mybatis.configuration;

import com.mt.mybatis.mapper.MapperRegistory;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * <p>Mybatsi配置类,读取解析配置文件信息</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class MtConfiguation {
    private Properties configProperties = new Properties();
    private String configLocation;
    private MtDataSource dataSource;
    private Properties mapperProperties = new Properties();
    private MapperRegistory mapperRegistory = new MapperRegistory();

    public MtConfiguation(String configLocation){
        this.configLocation = configLocation;
        init();
    }

    private void init(){
        //记载配置文件，这里使用properties代替xml解析
        loadConfigProperties();
        //初始化数据源信息
        initDataSource();
        //解析并加载mapper文件
        loadMapperRegistory();
    }

    public void loadConfigProperties(){
        if(this.configLocation==null){
            throw new RuntimeException("Mybatis's configLocation is not null!");
        }
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configLocation);
            this.configProperties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMapperRegistory(){
        this.scan();
        if(mapperProperties == null){
            throw new RuntimeException("Mybatis's mapperLocation is not null!");
        }
        try {
            mapperRegistory.doLoadMethodSqlMapping(mapperProperties);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void scan(){
        try {
            String mapperLocation = configProperties.getProperty("mapperLocation");
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(mapperLocation);
            this.mapperProperties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initDataSource(){
        this.dataSource = new MtDataSource(configProperties.getProperty("jdbc.url"),configProperties.getProperty("jdbc.driver"),
                configProperties.getProperty("jdbc.userName"),configProperties.getProperty("jdbc.passWord"));
    }

    public Properties getMapperProperties() {
        return mapperProperties;
    }

    public void setMapperProperties(Properties mapperProperties) {
        this.mapperProperties = mapperProperties;
    }

    public Properties getConfigProperties() {
        return configProperties;
    }

    public void setConfigProperties(Properties configProperties) {
        this.configProperties = configProperties;
    }

    public MtDataSource getDataSource() {
        return dataSource;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public void setDataSource(MtDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MapperRegistory getMapperRegistory() {
        return mapperRegistory;
    }

    public void setMapperRegistory(MapperRegistory mapperRegistory) {
        this.mapperRegistory = mapperRegistory;
    }
}
