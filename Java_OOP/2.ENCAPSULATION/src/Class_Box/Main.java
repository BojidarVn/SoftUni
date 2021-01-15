package Class_Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        double length = Double.parseDouble(Scanner.nextLine());
        double width = Double.parseDouble(Scanner.nextLine());
        double height = Double.parseDouble(Scanner.nextLine());

        Box box = new Box(length, width, height);



        System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume – %.2f", box.calculateVolume());

    }
}
