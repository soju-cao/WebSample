package com.yc.www.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.yc.www.jfinal.model.bean.Product;
import com.yc.www.jfinal.service.interceptor.LoginInterceptor;

/**
 * Created by Nick on 2017/3/11.
 */
public class ProductionController extends Controller {
    @ActionKey("/getGoods")
    @Before(LoginInterceptor.class)
    public void get() {
        Product p = new Product();
        p.setName("shoe");
        p.setSize("27");
        renderJson(p);
    }
}
