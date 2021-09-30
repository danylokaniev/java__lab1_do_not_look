package util;

import dao.ClientsImpl;

public abstract class Factory {
    public static Factory createFactory(){
        return new PostgresFactory();
    }

    public abstract ClientsImpl getClients();
}
