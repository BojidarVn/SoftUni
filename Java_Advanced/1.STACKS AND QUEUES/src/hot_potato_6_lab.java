import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class hot_potato_6_lab {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] children = Scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(Scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = queue.remove();
                queue.offer(child);
            }

            String name = queue.poll();
            System.out.println("Removed " + name);

        }
        String name =queue.peek();
        System.out.println("Last is " + name);
    }
}
