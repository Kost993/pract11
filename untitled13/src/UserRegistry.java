import java.util.*;
import java.util.function.Predicate;

public class UserRegistry {

    private HashMap<UserIdentifier, User> users = new HashMap<>();
    private int idCounter = 1;

    public void registerUser(String login, String password) {

        UserIdentifier identifier = new UserIdentifier(idCounter, login);

        // перевірка по імені
        for (UserIdentifier key : users.keySet()) {
            if (key.getName().equals(login)) {
                System.out.println("Користувач " + login + " вже існує");
                return;
            }
        }

        users.put(identifier, new User(identifier, password));
        idCounter++;
        System.out.println("Користувач зареєстрований");
    }

    public void loginUser(String login, String password) {

        for (User user : users.values()) {

            if (user.getIdentifier().getName().equals(login) &&
                    user.getPassword().equals(password)) {

                user.login();
                System.out.println("Успішний вхід");
                return;
            }
        }

        System.out.println("Помилка входу");
    }

    public void logoutUser(int id) {

        for (User user : users.values()) {

            if (user.getIdentifier().getId() == id) {
                user.logout();
                System.out.println("Користувач вийшов");
                return;
            }
        }

        System.out.println("Не знайдено");
    }

    // список користувачів
    public LinkedList<User> getUserList() {
        return new LinkedList<>(users.values());
    }

    // сортування
    public LinkedList<User> getInOrder(Comparator<User> comparator) {

        LinkedList<User> list = getUserList();

        list.sort(comparator);

        return list;
    }

    // фільтрація
    public LinkedList<User> getFiltered(Predicate<User> predicate) {

        LinkedList<User> result = new LinkedList<>();

        for (User user : users.values()) {
            if (predicate.test(user)) {
                result.add(user);
            }
        }

        return result;
    }

    public void printUsers(Collection<User> list) {
        for (User user : list) {
            System.out.println(user);
        }
    }
}