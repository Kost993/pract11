import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserRegistry registry = new UserRegistry();

        while (true) {

            System.out.println("\n1 - Реєстрація");
            System.out.println("2 - Вхід");
            System.out.println("3 - Вихід");
            System.out.println("4 - Показати всіх");
            System.out.println("5 - Сортувати за ім’ям");
            System.out.println("6 - Показати тільки онлайн");
            System.out.println("0 - Вийти");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Логін: ");
                    String login = sc.nextLine();

                    System.out.print("Пароль: ");
                    String pass = sc.nextLine();

                    registry.registerUser(login, pass);
                    break;

                case 2:
                    System.out.print("Логін: ");
                    login = sc.nextLine();

                    System.out.print("Пароль: ");
                    pass = sc.nextLine();

                    registry.loginUser(login, pass);
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    registry.logoutUser(id);
                    break;

                case 4:
                    registry.printUsers(registry.getUserList());
                    break;

                case 5:
                    registry.printUsers(
                            registry.getInOrder((u1, u2) ->
                                    u1.getIdentifier().getName()
                                            .compareTo(u2.getIdentifier().getName()))
                    );
                    break;

                case 6:
                    registry.printUsers(
                            registry.getFiltered(u -> u.isLoggedIn())
                    );
                    break;

                case 0:
                    return;
            }
        }
    }
}