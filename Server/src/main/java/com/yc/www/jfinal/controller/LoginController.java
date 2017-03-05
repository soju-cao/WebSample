package com.yc.www.jfinal.controller;

import com.jfinal.core.Controller;
import com.yc.www.jfinal.model.User;
import com.yc.www.jfinal.service.UserService;

/**
 * Created by Nick on 2017/3/5.
 */

public class LoginController extends Controller{
    private UserService userService = new UserService();

    public void login() {
       User user =  userService.findUser("nick", "nick");
        System.out.println(user);
        render("/html/hello.html");
    }
}
