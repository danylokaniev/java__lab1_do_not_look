package util;

import dao.ClientsImpl;
import dao.OrdersImpl;
import dao.TasksImpl;

public abstract class Factory {
    public static Factory createFactory(){
        return new PostgresFactory();
    }

    public abstract ClientsImpl getClients();
    public abstract TasksImpl getTasks();
    public abstract OrdersImpl getOrders();
}
