package nxu.it.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import javax.sql.DataSource;

public class DbHelper {
    public static final DataSource DATA_SOURCE;
    public static final Jdbi JDBI;

    static {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/todu");
        ds.setUser("root");
        ds.setPassword("123456");
        DATA_SOURCE = ds;
        JDBI = Jdbi.create(ds);
    }
}
