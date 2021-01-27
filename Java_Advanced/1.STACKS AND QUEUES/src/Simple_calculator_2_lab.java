import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Simple_calculator_2_lab {
    public static void main(String[] args) {


    Scanner Scanner = new Scanner(System.in);
        String[] tokens = Scanner.nextLine().split("\\s+");
        Deque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {

            int first = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;

            }


        }
        System.out.println(stack.pop());

//      vtori na4in

// int[] numbers = Arrays.stream(Scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        int n = numbers[0];
//        int s = numbers[1];
//        int x = numbers[2];
//
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//
//        for (int i = 0; i < n; i++) {
//            int number = Scanner.nextInt();
//            stack.push(number);
//        }
//
//        for (int i = 0; i < s; i++) {
//            stack.pop();
//        }
//
//        if (stack.contains(x)) {
//            System.out.println(true);
//
//        } else if (stack.isEmpty()) {
//            System.out.println(0);
//        } else {
//            System.out.println(Collections.min(stack));
//        }
//
//

    }
}
