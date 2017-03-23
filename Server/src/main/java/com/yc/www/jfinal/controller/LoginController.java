package com.yc.www.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.yc.www.jfinal.model.entity.User;

/**
 * Created by Nick on 2017/3/5.
 */


public class LoginController extends Controller{
    private UserService userService = new UserService();

    @ActionKey("/login")
    public void login() {
        String userName = getPara("userName");
        String pwd = getPara("pwd");
       User user =  userService.findUser("nick", "nick");
        System.out.println(user);
        renderJson(user);
    }
}
