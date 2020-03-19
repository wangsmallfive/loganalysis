package com.loganalysis.dao;

import com.loganalysis.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 12:56 上午
 */
@Mapper
public interface UserMapper {
    TUser login(TUser tUser);

    int register(TUser tuser);
}
