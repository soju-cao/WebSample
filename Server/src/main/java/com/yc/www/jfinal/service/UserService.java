package com.yc.www.jfinal.service;

import com.yc.www.jfinal.model.User;

/**
 * Created by Nick on 2017/3/5.
 */
public class UserService {

    public User findUser(String name,String password) {
        User user = new User();
        user = null;

        String sql = "select * from user where user_name='" + name + "' and user_password='" + password + "';";

        user = User.dao.findFirst(sql);

        System.out.printf("sql:"+sql);

        return user;
    }
}
