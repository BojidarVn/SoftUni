import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Basic_Stack_Operations_exercise_2 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        int[] input= Arrays.stream(Scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbers=new ArrayDeque<>();

        int n=input[0];
        int numbersToRemove=input[1];
        int target=input[2];




        for (int i = 0; i < n; i++) {
            numbers.push(Scanner.nextInt());
        }

        for (int i = 0; i < numbersToRemove; i++) {
            numbers.pop();
        }

        if (numbers.contains(target)) {
            System.out.println("true");
        } else if (numbers.isEmpty()) {
            System.out.println(0);

        } else {

            System.out.println(Collections.min(numbers));
        }

    }
}
