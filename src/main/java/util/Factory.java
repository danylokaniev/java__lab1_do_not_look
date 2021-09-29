package util;

import dao.interfaces.Users;

public abstract class Factory {
    public static Factory createFactory(){
        return new MySqlFactory();
    }

    public abstract Users getUsers();
}
