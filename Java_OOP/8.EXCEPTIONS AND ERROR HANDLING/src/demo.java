import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        List<User> users=new ArrayList<>();

        while (true) {

            System.out.println("Register From");
            System.out.print("Username: ");
            String username = Scanner.nextLine();
            System.out.print("Password: ");
            System.out.println();
            String password = Scanner.nextLine();

            try {
                User user = new User(username,password);
                users.add(user);
            } catch (InvalidUserCreationException ex) {
                System.out.println(ex.getMessage());
                continue;

            }

            users.add(new User(username,password));
            System.out.println("Successfully registered as" + username);
        }


    }
}
