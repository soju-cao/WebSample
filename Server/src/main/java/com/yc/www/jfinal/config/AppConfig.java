package com.yc.www.jfinal.config;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.yc.www.jfinal.controller.LoginController;
import com.yc.www.jfinal.model.User;

import java.util.Properties;

/**
 * Created by Nick on 2017/3/5.
 */
public class AppConfig extends JFinalConfig {

    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setEncoding("UTF-8");
    }

    public void configRoute(Routes routes) {
        routes.add("/", LoginController.class);
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        //Properties p = loadPropertyFile("jdbc.properties");
        PropKit.use("app-config.txt");
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        plugins.add(c3p0Plugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(arp);

        //add the entity mapping
        arp.addMapping("user", User.class);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("basePath"));
    }
}
