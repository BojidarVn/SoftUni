import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Math_Potato_7_lab {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] children = Scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(Scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);

        int cycles=1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = queue.remove();
                queue.offer(child);
            }

            String name = queue.peek();
            if (!isPrime(cycles)) {

                System.out.println("Removed " + name);
                queue.poll();
            } else {
                System.out.println("Prime " + name);

            }
            cycles++;
        }
        String name =queue.peek();
        System.out.println("Last is " + name);
    }

    private static boolean isPrime(int number) {

        if (number==1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number%i == 0) {
                return false;
            }
        }
        return true;

    }
}
