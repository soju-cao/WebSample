package com.yc.www.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.yc.www.jfinal.model.bean.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Nick on 2017/3/6.
 */
public class IndexController extends Controller {
    Logger logger = LogManager.getLogger(IndexController.class);

    @ActionKey("/index")
    public void index() {
        render("login.html");
    }

    @ActionKey("/test")
    public void test() {

        Test test = new Test();
        test.setAge("13");
        test.setName("nick");
        renderJson(test);
    }
}
