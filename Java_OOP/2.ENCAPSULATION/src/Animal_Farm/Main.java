package Animal_Farm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String name=Scanner.nextLine();
        int age=Integer.parseInt(Scanner.nextLine());

        Chicken chicken=new Chicken(name,age);
        System.out.println(chicken);
    }
}
