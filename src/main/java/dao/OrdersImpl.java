package dao;

import objects.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

public class OrdersImpl implements EntityImpl<Order> {
    protected Statement statement;
    private static String tableName = "order";

    public OrdersImpl(Statement statement) {
        this.statement = statement;
        this.createTable();
    }

    public static String getTableName() {
        return TasksImpl.tableName;
    }

    private void createTable() {
        String sqlCreateTableStatement =
                "CREATE TABLE IF NOT EXISTS \"" + this.tableName + "\" (" +
                        "id varchar(45) PRIMARY KEY NOT NULL," +
                        "clientId varchar(450) NOT NULL REFERENCES " + ClientsImpl.getTableName() + "," +
                        "taskId varchar(450) NOT NULL  REFERENCES " + TasksImpl.getTableName() +
                        ")";
        this.executeUpdate(sqlCreateTableStatement);
    }

    public void insert(Order order) {
        String sql = "INSERT INTO \"" + this.tableName + "\""
                + " (id, clientId, taskId)"
                + " VALUES ('"
                + order.getId() + "', '"
                + order.getClientId() + "', '"
                + order.getTaskId() + "')";

        this.executeUpdate(sql);
    }

    public Order getById(UUID id) {
        String sql = "SELECT * FROM \"" + this.tableName + "\"  WHERE id = '" + id + "'";
        ResultSet query = this.executeQuery(sql);
        return this.createEntityFromQuery(query);
    }

    public Order getByPropertyName(String propertyName, String propertyValue) {
        String sql = "SELECT * FROM \"" + this.tableName + "\" WHERE \""
                + this.tableName + "\"." + propertyName.toLowerCase(Locale.ROOT) + " = '" + propertyValue + "'";
        System.out.println(sql);
        ResultSet query = this.executeQuery(sql);
        return this.createEntityFromQuery(query);
    }

    public ArrayList<Order> getAll() {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM \"" + this.tableName +"\"";
        this.executeSelectQuery(sql, orders);
        return orders;
    }

    public Order createEntityFromQuery(ResultSet resultSet) {
        try {
            String id = resultSet.getString("id");
            String clientId = resultSet.getString("clientId");
            String taskId = resultSet.getString("taskId");
            return new Order(UUID.fromString(id), UUID.fromString(clientId), UUID.fromString(taskId));
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

    public void executeSelectQuery(String query, ArrayList<Order> orders) {
        try {
            ResultSet resultSet = this.statement.executeQuery(query);
            while (resultSet.next()) {
                Order order = this.createEntityFromQuery(resultSet);
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
