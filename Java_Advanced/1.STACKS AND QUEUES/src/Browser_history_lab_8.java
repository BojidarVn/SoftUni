import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_history_lab_8 {


    public static void main(String[] args) {

//        Scanner Scanner = new Scanner(System.in);
//
//        ArrayDeque<String> stack = new ArrayDeque<>();
//        ArrayDeque<String> forward = new ArrayDeque<>();
//
//        String navigation = Scanner.nextLine();
//
//        String currentURL = "";
//
//        while (!navigation.equals("Home")) {
//
//            if (navigation.equals("back")) {
//                if (!stack>1) {
//                    forward.push(currentURL);
//                    currentURL = stack.pop();
//                } else {
//                    System.out.println("no previous URLs");
//                    navigation = Scanner.nextLine();
//                    forward.push(currentURL);
//                    continue;
//                }
//            }
//            if (navigation.equals("forward")) {
//                if (!forward.isEmpty()) {
//                    forward.pop();
//                } else {
//                    System.out.println("no next URLs");
//                }
//
//
//            } else {
//                if (!currentURL.isEmpty()) {
//                    stack.push(currentURL);
//                }
//                currentURL = navigation;
//                forward.push(currentURL);
//            }
//            System.out.println(currentURL);
//            navigation = Scanner.nextLine();
//        }


        // da se opitam da opravq gornata zada4a ot dolnata!


        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stackUrl = new ArrayDeque<>();
        ArrayDeque<String> forwardUrl = new ArrayDeque<>();
        String input = "";


        while (!"Home".equals(input = scan.nextLine())) {

            if (input.equals("back")) {
                if (stackUrl.size() > 1) {
                    String toRemove = stackUrl.pop();
                    forwardUrl.push(toRemove);
                    System.out.println(stackUrl.peek());
                } else {
                    System.out.println("no previous URLs");
                }
                continue;
            }
            if (input.equals("forward")) {
                if (forwardUrl.size() >= 1) {
                    String something = forwardUrl.pop();
                    System.out.println(something);
                    stackUrl.push(something);
                } else {
                    System.out.println("no next URLs");
                }
                continue;
            }
            System.out.println(input);
            stackUrl.push(input);
            forwardUrl.clear();
        }


    }
}


