import dao.interfaces.Users;
import objects.User;
import util.Factory;

public class init {
    public static Factory factory = Factory.createFactory();
    public static Users usersDAO = factory.getUsers();

    public static void main(String[] args){
        //Create user
        System.out.println("Create user");
        String login = "vlad"+java.time.LocalDateTime.now();
        final User newUser = new User("Vlad", login, "qwerty", User.userRoles.Admin);
        usersDAO.insert(newUser);

//        //Get user by login
//        System.out.println("Get user by login");
//        final User userByLogin = usersDAO.getByLogin(login);
//        System.out.println(userByLogin);
//
//        //Get user by id
//        System.out.println("Get user by id");
//        final User userById = usersDAO.getById(userByLogin.getId());
//        System.out.println(userById);
//
//        //Get all users
//        System.out.println("Get all users");
//        ArrayList<User> users = usersDAO.getAll();
//        users.forEach((user) -> System.out.println(user.toString()));
//
//        System.out.println();
    }
}
