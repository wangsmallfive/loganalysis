package com.loganalysis.service;

import com.loganalysis.entity.TUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 12:57 上午
 */
@Component
public interface UserService {
    TUser login(TUser tUser);

    int register(TUser tuser);
}
