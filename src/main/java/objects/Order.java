package objects;

import java.util.UUID;

public class Order {

    private UUID id;
    private UUID clientId;
    private UUID taskId;

    public Order(UUID id, UUID clientId, UUID taskId) {
        this.id = id;
        this.clientId = clientId;
        this.taskId = taskId;
    }

    public Order(UUID clientId, UUID taskId) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.taskId = taskId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Order: \n"
                + "\t id: " + this.id + "\n"
                + "\t clientId: " + this.clientId + "\n"
                + "\t taskId: " + this.taskId + "\n";
    }
}
