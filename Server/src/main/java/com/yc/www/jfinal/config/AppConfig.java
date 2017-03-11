package com.yc.www.jfinal.config;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;
import com.yc.www.jfinal.controller.IndexController;
import com.yc.www.jfinal.controller.LoginController;
import com.yc.www.jfinal.controller.ProductionController;
import com.yc.www.jfinal.controller.UserController;
import com.yc.www.jfinal.model.entity.User;

/**
 * Created by Nick on 2017/3/5.
 */
public class AppConfig extends JFinalConfig {

    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setEncoding("UTF-8");
        constants.setError401View("401.html");
        constants.setError404View("401.html");
    }

    public void configRoute(Routes routes) {
        routes.setBaseViewPath("/pages");//base path view
        routes.add("/", IndexController.class, "/");
        routes.add("/login", LoginController.class, "/");
        routes.add("/user", UserController.class, "/");
        routes.add("/goods", ProductionController.class, "/");
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        //Properties p = loadPropertyFile("jdbc.properties");
        Prop property = PropKit.use("app-config.txt");
        C3p0Plugin c3p0Plugin = new C3p0Plugin(property.get("jdbcUrl"), property.get("user"), property.get("password").trim());

        plugins.add(c3p0Plugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        arp.setBaseSqlTemplatePath(PathKit.getRootClassPath());
        arp.addSqlTemplate("sql_template/user.sql");
        arp.setDialect(new MysqlDialect());
        plugins.add(arp);

        //add the mapping between entity and table in sql
        arp.addMapping("user", "id", User.class);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("basePath"));
    }
}
