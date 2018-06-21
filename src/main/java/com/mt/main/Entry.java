package com.mt.main;

import com.mt.main.dao.PersonDao;
import com.mt.main.domain.Person;
import com.mt.mybatis.configuration.MtConfiguration;
import com.mt.mybatis.session.MtSqlSession;
import com.mt.mybatis.session.MtSqlSessionFactory;
import com.mt.mybatis.session.MtSqlSessionFactoryBuilder;

/**
 * <p>入口</p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public class Entry {

    public static void main(String[] args) {
        MtConfiguration configuration = new MtConfiguration("mybatis-config.properties");
        MtSqlSessionFactoryBuilder sqlSessionFactoryBuilder = new MtSqlSessionFactoryBuilder(configuration);
        MtSqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build();
        MtSqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        Person person = personDao.queryPersonById(1l);
        System.out.println(person);
    }
}
