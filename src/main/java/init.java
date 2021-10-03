import dao.ClientsImpl;
import dao.OrdersImpl;
import dao.TasksImpl;
import objects.Client;
import objects.Order;
import objects.Task;
import util.Factory;

public class init {
    public static Factory factory = Factory.createFactory();
    public static ClientsImpl clientsDAO = factory.getClients();
    public static TasksImpl tasksDAO = factory.getTasks();
    public static OrdersImpl ordersDAO = factory.getOrders();

    public static void main(String[] args){
        final Client newClient = new Client("RANDOM " + Math.random(), "EMAIL", "qwerty");
        clientsDAO.insert(newClient);
        System.out.println("Create new client: " + clientsDAO.getById(newClient.getId()));
        System.out.println("Get new client by property: " + clientsDAO.getByPropertyName("email", newClient.getEmail()));
        System.out.println("All clients: ");
        clientsDAO.getAll().forEach((user) -> System.out.println(user.toString()));

        final Task newTask = new Task("Task ", "Description", Math.random());
        tasksDAO.insert(newTask);
        System.out.println("Create new task: " + tasksDAO.getById(newTask.getId()));
        System.out.println("Get new task by property: " + tasksDAO.getByPropertyName("name", newTask.getName()));
        System.out.println("All tasks: ");
        tasksDAO.getAll().forEach((user) -> System.out.println(user.toString()));

        final Order newOrder = new Order(newClient.getId(), newTask.getId());
        ordersDAO.insert(newOrder);
        System.out.println("Create new task: " + ordersDAO.getById(newOrder.getId()));
        System.out.println("Get new task by property: " + ordersDAO.getByPropertyName("clientId", newOrder.getClientId().toString()));
        System.out.println("All tasks: ");
        ordersDAO.getAll().forEach((user) -> System.out.println(user.toString()));
    }
}
