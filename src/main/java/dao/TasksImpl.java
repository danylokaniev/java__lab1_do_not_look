package dao;

import objects.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

public class TasksImpl implements EntityImpl<Task> {

    protected Statement statement;
    public static String tableName = "task";

    public TasksImpl(Statement statement) {
        this.statement = statement;
        this.createTable();
    }

    public static String getTableName() {
        return TasksImpl.tableName;
    }

    private void createTable() {
        String sqlCreateTableStatement =
                "CREATE TABLE IF NOT EXISTS " + this.tableName + " (" +
                        "id varchar(45) PRIMARY KEY NOT NULL," +
                        "name varchar(450) NOT NULL," +
                        "description varchar(450) NOT NULL," +
                        "price float(6) NOT NULL" +
                        ")";

        this.executeUpdate(sqlCreateTableStatement);
    }

    public void insert(Task order) {
        String sql = "INSERT INTO \"" + this.tableName + "\""
                + " (id, name, description, price)"
                + " VALUES ('"
                + order.getId() + "', '"
                + order.getName() + "', '"
                + order.getDescription() + "', '"
                + order.getPrice() + "')";

        this.executeUpdate(sql);
    }

    public Task getById(UUID id) {
        String sql = "SELECT * FROM \"" + this.tableName + "\"  WHERE id = '" + id + "'";
        ResultSet query = this.executeQuery(sql);
        return this.createEntityFromQuery(query);
    }

    public Task getByPropertyName(String propertyName, String propertyValue) {
        String sql = "SELECT * FROM \"" + this.tableName + "\" WHERE \""
                + this.tableName + "\"." + propertyName.toLowerCase(Locale.ROOT) + " = '" + propertyValue + "'";
        ResultSet query = this.executeQuery(sql);
        return this.createEntityFromQuery(query);
    }

    public ArrayList<Task> getAll() {
        ArrayList<Task> orders = new ArrayList<>();
        String sql= "SELECT * FROM \"" + this.tableName +"\"";
        this.executeSelectQuery(sql, orders);
        return orders;
    }

    public Task createEntityFromQuery(ResultSet resultSet) {
        try {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            Double price = resultSet.getDouble("price");
            return new Task(UUID.fromString(id), name, description, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet executeQuery(String query) {
        try {
            ResultSet queryResult = this.statement.executeQuery(query);
            queryResult.next();
            return queryResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeSelectQuery(String query, ArrayList<Task> orders) {
        try {
            ResultSet resultSet = this.statement.executeQuery(query);
            while (resultSet.next()) {
                Task order = this.createEntityFromQuery(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            this.statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
