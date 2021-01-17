package Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String name=Scanner.nextLine();

       Car car =new Ferrari(name);
        System.out.println(car.toString());
    }
}
