package dao;

import objects.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class ClientsImpl implements EntityImpl<Client> {
    protected Statement statement;
    private String tableName = "client";

    public ClientsImpl(Statement statement) {
        this.statement = statement;
        this.createTable();
    }

    private void createTable() {
        String sqlCreateTableStatement =
                "CREATE TABLE IF NOT EXISTS " + this.tableName + " (" +
                        "id varchar(45) PRIMARY KEY NOT NULL," +
                        "name varchar(450) NOT NULL," +
                        "email varchar(450) NOT NULL," +
                        "password varchar(450) NOT NULL" +
                        ")";

        this.executeUpdate(sqlCreateTableStatement);
    }

    public void insert(Client client) {
        String sql = "INSERT INTO " + this.tableName
                + " (id, name, password, email)"
                + " VALUES ('"
                + client.getId() + "', '"
                + client.getName() + "', '"
                + client.getPassword() + "', '"
                + client.getEmail() + "')";

        this.executeUpdate(sql);
    }

    public Client getById(UUID id) {
        String sql = "SELECT * FROM " + this.tableName + " WHERE id = '" + id + "'";
        ResultSet query = this.executeQuery(sql);
        return this.createClassFromQuery(query);
    }

    public Client getByPropertyName(String propertyName, String propertyValue) {
        String sql = "SELECT * FROM " + this.tableName + " WHERE " + propertyName + " = '" + propertyValue + "'";
        ResultSet query = this.executeQuery(sql);
        return this.createClassFromQuery(query);
    }

    public ArrayList<Client> getAll() {
        ArrayList<Client> clients = new ArrayList<>();
        String sql= "SELECT * FROM " + this.tableName;
        this.executeSelectQuery(sql, clients);
        return clients;
    }

    public Client createClassFromQuery(ResultSet resultSet) {
        try {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            return new Client(UUID.fromString(id), name, email, password);
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

    public void executeSelectQuery(String query, ArrayList<Client> clients) {
        try {
            ResultSet resultSet = this.statement.executeQuery(query);
            while (resultSet.next()) {
                Client client = this.createClassFromQuery(resultSet);
                clients.add(client);
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
