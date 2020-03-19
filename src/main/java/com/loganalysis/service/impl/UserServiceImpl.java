package com.loganalysis.service.impl;

import com.loganalysis.dao.UserMapper;
import com.loganalysis.entity.TUser;
import com.loganalysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 12:58 上午
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public TUser login(TUser tuser) {
        return userMapper.login(tuser);
    }

    @Override
    public int register(TUser tuser) {
        return userMapper.register(tuser);
    }
}
