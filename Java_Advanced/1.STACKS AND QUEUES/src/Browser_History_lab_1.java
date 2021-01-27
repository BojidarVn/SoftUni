import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History_lab_1 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String navigation = Scanner.nextLine();

        String currentURL = "";

        while (!navigation.equals("Home")) {

            if (navigation.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    navigation = Scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.isEmpty()) {
                    stack.push(currentURL);
                }
                currentURL = navigation;
            }
            System.out.println(currentURL);
            navigation = Scanner.nextLine();
        }
// vtori na4in za reshenie
//           Scanner Scanner = new Scanner(System.in);
//        ArrayDeque<String> history = new ArrayDeque<>();
//        String input = Scanner.nextLine();
//
//        while (!input.equals("Home")) {
//            boolean error = false;
//            if (input.equals("back")) {
//
//                if (history.size() < 2) {
//                    System.out.println("no previous URLs");
//                    error = true;
//                } else {
//                    history.pop();
//                }
//
//            } else {
//                history.push(input);
//            }
//            if (!error) {
//                System.out.println(history.peek());
//            }
//            input = Scanner.nextLine();
//        }
//
//
//

    }
}
