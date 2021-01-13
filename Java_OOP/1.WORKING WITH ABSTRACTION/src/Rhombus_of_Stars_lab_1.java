import java.util.Scanner;

public class Rhombus_of_Stars_lab_1 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        int n = readN(new Scanner(System.in));

        for (int i = 1; i <= n; i++) {
            printSingleLineOfStars(n, i);
        }

        for (int i = n - 1; i >= 1; i--) {
            printSingleLineOfStars(n, i);
        }

    }

    private static void printSingleLineOfStars(int totalNumberOfStars, int starsToPrint) {
        int leadingSpace = totalNumberOfStars - starsToPrint;
        for (int i = 0; i < leadingSpace; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < starsToPrint; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static int readN(Scanner scanner) {
        return scanner.nextInt();
    }
}
