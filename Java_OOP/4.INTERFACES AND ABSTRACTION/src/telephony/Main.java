package telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

String[] numbers=Scanner.nextLine().split("\\s+");
String[] urls=Scanner.nextLine().split("\\s+");


Smartphone smartphone=new Smartphone(List.of(numbers), List.of(urls));

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }
}
