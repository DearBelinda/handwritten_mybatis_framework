package com.mt.main.dao;

import com.mt.main.domain.Person;

/**
 * <p></p>
 *
 * @author grand 2018/6/20
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人}
 * @modify by reason:{方法名}:{原因}
 */
public interface PersonDao {

    Person queryPersonById(Long id);
}
