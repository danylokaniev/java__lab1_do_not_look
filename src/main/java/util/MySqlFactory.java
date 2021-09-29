package util;

import dao.UsersImpl;
import java.sql.Statement;

public class MySqlFactory extends Factory {
    static Statement statement = null;

    public MySqlFactory(){
        try {
            System.out.println("Connect to database");
            this.statement = ConnectionPool.getConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public UsersImpl getUsers(){
        return new UsersImpl(this.statement);
    }

}
