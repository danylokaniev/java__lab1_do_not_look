package objects;

import java.util.Date;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public Client(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID();
    }

    public Client(UUID id, String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CLIENT: \n"
                + "\t name: " + this.name + "\n"
                + "\t email: " + this.email + "\n"
                + "\t id: " + this.id + "\n";
    }

}
