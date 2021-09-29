package dao.interfaces;

import objects.User;
import java.util.ArrayList;

public interface Users {
    public void insert(User user);
    public User getById(int id);
    public User getByLogin(String login);
    public ArrayList<User> getAll();
}
