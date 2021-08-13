package com.itdfq.mybatisgeneratortest.service;


import com.itdfq.mybatisgeneratortest.entity.User;
import com.itdfq.mybatisgeneratortest.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 14:43
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> findAll(){
        return  userMapper.selectByExample(null);
    }
}
