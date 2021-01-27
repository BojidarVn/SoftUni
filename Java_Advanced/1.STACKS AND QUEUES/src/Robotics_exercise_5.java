import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics_exercise_5 {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String[] input = Scanner.nextLine().split(";");

//imena na roboti
        String[] robots = new String[input.length];

        // vreme na rabota
        int[] processTimes = new int[input.length];

        // segashno vreme za rabota
        int[] currentRobotTime = new int[input.length];


        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("-");
            robots[i] = tokens[0];
            processTimes[i] = Integer.parseInt(tokens[1]);
            currentRobotTime[i] = 0;
        }

        int[] inputTime = Arrays.stream(Scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();

        int time = inputTime[0] * 3600 + inputTime[1] * 60 + inputTime[2];

        ArrayDeque<String> products = new ArrayDeque<>();

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
                    System.out.printf("%s - %s [%s]%n", robots[i], currentItem, getTime(time));
                    currentRobotTime[i] = processTimes[i];
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                products.offer(currentItem);
            }
        }

    }

    private static String getTime(int time) {
        int hours = time / 3600 % 24;
        int minutes = time / 60 % 60;
        int second = time % 60;


        return String.format("%02d:%02d:%02d", hours, minutes, second);
    }
}
