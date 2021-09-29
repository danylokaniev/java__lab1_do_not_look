package dao;

import dao.interfaces.Users;
import objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersImpl implements Users {

    protected Statement statement;
    public UsersImpl(Statement statement){
        this.statement = statement;
    }

    public void insert(User user) {
        String sql;
        sql = "INSERT INTO test (newcolumn) VALUES (123)";
//        sql = String.format(sql, "123");

        System.out.println(sql);

        try {
            this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getById(int id) {
        User user = null;
        String sql;
        sql = "SELECT * FROM `users` WHERE `id`='%s' limit 1";
        sql = String.format(sql, id);

        try {
            ResultSet resultSet = this.statement.executeQuery(sql);
            resultSet.next();
            user = this.convertToClass(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getByLogin(String login) {
        User user = null;
        String sql;
        sql = "SELECT * FROM `users` WHERE `login`='%s' limit 1";
        sql = String.format(sql, login);

        try {
            ResultSet resultSet = this.statement.executeQuery(sql);
            resultSet.next();
            user = this.convertToClass(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM `users`";

        try {
            ResultSet resultSet = this.statement.executeQuery(sql);
            while(resultSet.next()){
                User user = this.convertToClass(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User convertToClass(ResultSet resultSet) {
        User user = null;
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            User.userRoles role = User.userRoles.valueOf(resultSet.getString("role"));
            user = new User(id, name, login, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
