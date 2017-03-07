package com.yc.www.jfinal.controller;

import com.jfinal.core.Controller;
import com.yc.www.jfinal.model.bean.UserVO;
import com.yc.www.jfinal.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Nick on 2017/3/6.
 */
public class UserController extends Controller {
    Logger log = LogManager.getLogger(UserController.class);

    private UserService userService = new UserService();
    public void getUser() {
        String userName = getPara(0);
        String password = getPara(1);
        log.info("the userName=" + userName);
        UserVO user = userService.findUserByName("nick");

        renderJson("user", user);

    }
}
