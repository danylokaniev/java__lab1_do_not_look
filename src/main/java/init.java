import dao.ClientsImpl;
import objects.Client;
import util.Factory;

public class init {
    public static Factory factory = Factory.createFactory();
    public static ClientsImpl clientsDAO = factory.getClients();

    public static void main(String[] args){
        final Client newClient = new Client("RANDOM " + Math.random(), "EMAIL", "qwerty");
        clientsDAO.insert(newClient);
        System.out.println("Create new client: " + clientsDAO.getById(newClient.getId()));
        System.out.println("Get new client by property: " + clientsDAO.getByPropertyName("email", newClient.getEmail()));
        System.out.println("All clients: ");
        clientsDAO.getAll().forEach((user) -> System.out.println(user.toString()));
    }
}
