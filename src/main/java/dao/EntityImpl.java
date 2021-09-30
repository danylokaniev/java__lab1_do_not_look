package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public interface EntityImpl<T> {
    public String tableName = "";
    public ResultSet executeQuery(String query) throws SQLException;
    public void executeUpdate(String query) throws SQLException;
    public T createClassFromQuery(ResultSet query) throws SQLException;
    public void executeSelectQuery(String query, ArrayList<T> entities) throws SQLException;
    public T getByPropertyName(String propertyName, String propertyValue);
    public T getById(UUID id);
    public ArrayList<T> getAll();
}
