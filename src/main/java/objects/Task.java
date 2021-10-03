package objects;

import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private String description;
    private Double price;

    public Task(UUID id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Task(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Task: \n"
                + "\t name: " + this.name + "\n"
                + "\t description: " + this.description + "\n"
                + "\t id: " + this.id + "\n"
                + "\t price: " + this.price + "\n";
    }
}
