import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class Nested_Folders_LAB_8 {
    public static void main(String[] args) {

        File file = new File("F:\\Bobi\\softuni\\Advance JAVA\\Stream file and directories\\Files-and-Streams");

        Deque<File> queue = new ArrayDeque<>();

        queue.offer(file);
        int counter = 0;
        while (!queue.isEmpty()) {

            File poll = queue.poll();
            System.out.println(poll.getName());

            File[] files = poll.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                } else {
                    //  System.out.println(f.getName());
                }
            }

            counter++;
        }
        System.out.println(counter + " folders");
    }
}
