package com.yc.www.jfinal.service;

import com.jfinal.kit.JMap;
import com.jfinal.plugin.activerecord.*;
import com.yc.www.jfinal.model.entity.User;
import com.yc.www.jfinal.model.bean.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


/**
 * Created by Nick on 2017/3/5.
 */
public class UserService {
    Logger log  = LogManager.getLogger(UserService.class);
    public User findUser(String name,String password) {
        User user = new User();
        user = null;

        String sql = "select * from user where name='" + name + "' and password='" + password + "';";

        user =User.dao.findFirst(sql);

        System.out.printf("sql:"+sql);

        return user;
    }

    public UserVO findUserByName(String name) {
        UserVO user = new UserVO();
        JMap condition = JMap.create("name", name);
        SqlPara sp = Db.getSqlPara("user.getUserByName", condition);
        List<Record> userList =  Db.find(sp);
        Record re = userList.get(0);

        String name1 = re.getStr("name");
        String password = re.getStr("password");
        user.setName(name1);
        user.setAge(re.getStr("age"));
        log.info("get the user, age = " + user.getAge());
        return user;
    }
}
