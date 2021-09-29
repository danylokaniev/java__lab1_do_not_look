package objects;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private userRoles role;

    public User(int id, String name, String login, String password, userRoles role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String name, String login, String password, userRoles role) {
        this.id = 0;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public userRoles getRole() {
        return role;
    }

    public enum userRoles{
        Admin,
        User
    }

    public String toString(){
        return String.format("#%s | %s | %s | %s", this.id, this.name, this.login, this.role);
    }
}
