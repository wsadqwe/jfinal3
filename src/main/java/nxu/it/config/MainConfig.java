package nxu.it.config;

import com.jfinal.config.*;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.template.Engine;
import com.mysql.cj.jdbc.MysqlDataSource;
import nxu.it.model.Category;
import nxu.it.model.Post;
import nxu.it.model._MappingKit;


public class MainConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        // 打开JFinal的开发模式  true表示打开  false表示关闭
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.scan("nxu.it.controller");
        routes.setBaseViewPath("/WEB-INF/templates");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/todu");
        ds.setUser("root");
        ds.setPassword("123456");

        ActiveRecordPlugin arp = new ActiveRecordPlugin(ds);
        arp.setDialect(new MysqlDialect());
        arp.setShowSql(true);
        _MappingKit.mapping(arp);
        plugins.add(arp);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new SessionInViewInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
