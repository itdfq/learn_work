package com.itdfq.springbootmongodb.dao;

import com.itdfq.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author Qianmo
 * @Date 2021/8/10 9:26
 * @Description:
 */
public interface UserMapper extends MongoRepository<User,String> {

}
