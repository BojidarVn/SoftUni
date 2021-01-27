import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Maximum_Element_exercise_3 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] tokens = Scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    numbers.push(Integer.parseInt(tokens[1]));
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }


    }
}
