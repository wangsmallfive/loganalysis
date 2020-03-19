package com.loganalysis.entity;

import org.springframework.stereotype.Component;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 12:57 上午
 */
@Component
public class TUser {
    private Integer id;
    private String loginname;
    private String password;
    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
