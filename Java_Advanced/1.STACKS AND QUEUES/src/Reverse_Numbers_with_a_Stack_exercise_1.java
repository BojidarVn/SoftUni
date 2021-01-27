import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Numbers_with_a_Stack_exercise_1 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int[] input= Arrays.stream(Scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbers=new ArrayDeque<>();

        for (int element: input) {
            numbers.push(element);
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));

     //втори начин

        //
        //        String[] input = Scanner.nextLine().split("\\s+");
        //
        //        ArrayDeque<String> stack = new ArrayDeque<>();
        //
        //        for (int i = 0; i < input.length; i++) {
        //            //int number[i] = Integer.parseInt(Scanner.nextLine());
        //            stack.push(input[i]);
        //        }
        //        while (!stack.isEmpty()) {
        //
        //            String name=stack.pop();
        //
        //            System.out.print(name+ " ");
        //
        //        }
        //
        //

    }
}
