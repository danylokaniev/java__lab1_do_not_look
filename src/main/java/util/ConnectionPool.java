package util;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static BasicDataSource ds = new BasicDataSource();

    static {
        Dotenv dotenv = Dotenv.load();
        ds.setUrl(dotenv.get("DATABASE_URL"));
        ds.setUsername(dotenv.get("DATABASE_USERNAME"));
        ds.setPassword(dotenv.get("DATABASE_PASSWORD"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
