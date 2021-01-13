package Cards_with_Power_EXERCISE_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String type=Scanner.nextLine();
        String suit=Scanner.nextLine();

        Card card=new Card(type,suit);

        System.out.println(card.toString());

    }
}
