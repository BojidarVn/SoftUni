import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String[] input = Scanner.nextLine().split(";");

        String[] robots = new String[input.length];

        int[] processTime = new int[input.length];

        int[] currentRobotTime = new int[input.length];

        ArrayDeque<String> products = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {   // martin krs
            String[] tokens = input[i].split("-");
            robots[i] = tokens[0];
            processTime[i] = Integer.parseInt(tokens[1]);
            currentRobotTime[i] = 0;

        }
        int[] inputTime = Arrays.stream(Scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int time = inputTime[0] * 60 * 60 + inputTime[1] * 60 + inputTime[2];

        String product = "";

        while (!(product = Scanner.nextLine()).equals("End")) {
            products.offer(product);
        }


        while (!products.isEmpty()) {

            for (int i = 0; i < robots.length; i++) {
                if (currentRobotTime[i] > 0) {
                    currentRobotTime[i]--;

                }
            }

            time++;

            String currentItem = products.poll();
            boolean isTaken = false;


            for (int i = 0; i < robots.length; i++) {
                if (currentRobotTime[i] == 0) {

                    System.out.printf("%s - %s - %s%n", robots[i], currentItem, getTime(time));
                    currentRobotTime[i] = processTime[i];
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                products.offer(currentItem);
            }
        }


            System.out.println();

    }

    private static String getTime(int time) {
        int hours = time / 3600%24;
        int mins = time / 60 % 60;
        int seconds = time % 60;


        return String.format("%02d:%02d:%2d", hours, mins, seconds);
    }


}
