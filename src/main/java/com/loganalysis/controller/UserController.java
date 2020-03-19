package com.loganalysis.controller;

import com.loganalysis.entity.TUser;
import com.loganalysis.service.AnalysisService;
import com.loganalysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 12:56 上午
 */
@Controller

public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AnalysisService analysisService;
    //登录操作
    @RequestMapping("/loginUser")
    public String login(@RequestParam("loginname") String loginname, @RequestParam("password") String password, HttpServletRequest request,HttpSession session){
                TUser user = new TUser();
        user.setLoginname(loginname);
        user.setPassword(password);
        TUser u1 =userService.login(user);

        if (u1==null){
            return "index";
        }else{
            return "redirect:/queryAnalysis";
        }
    }
    //注册操作
    @RequestMapping("/register")
    public String register(@RequestBody TUser tuser){
        int su = userService.register(tuser);
        if(su==0){
            System.out.println("----");
        }
        return "index";
    }
    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/toIndex");
    }
    //跳转首页（登录页）
    @RequestMapping("/toIndex")
    public String show(){
        return "index";
    }
    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

}
