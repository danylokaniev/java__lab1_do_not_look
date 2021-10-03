package util;

import dao.ClientsImpl;
import dao.EntityImpl;
import dao.OrdersImpl;
import dao.TasksImpl;
import objects.Client;

import java.sql.Statement;

public class PostgresFactory extends Factory {
    static Statement statement = null;

    public PostgresFactory() {
        try {
            System.out.println("Connect to database");
            this.statement = ConnectionPool.getConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClientsImpl getClients() {
        return new ClientsImpl(this.statement);
    }

    public TasksImpl getTasks() {
        return new TasksImpl(this.statement);
    }

    public OrdersImpl getOrders(){
        return new OrdersImpl(this.statement);
    }
}
