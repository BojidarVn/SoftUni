package Food_Shortage_EXERCISE_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_tursi_greshka {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int N = Integer.parseInt(Scanner.nextLine());

        List<Buyer> citizens = new ArrayList<>();
        List<Buyer> rebels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = Scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (input.length == 4) {
                Buyer citizen = new Citizen(name, age, input[2], input[3]);
                citizens.add(citizen);
            } else {
        //        Person rebel = new Rebel(name, age, input[2]);
           //     Buyer.add(rebel);
            }
        }

        String name=Scanner.nextLine();

        while (!name.equals("End")) {

            checkFood(citizens,name);
            checkFood(rebels,name);



            name=Scanner.nextLine();
        }


        System.out.println();
    }

    public static void checkFood(List<Buyer> people, String name) {

     //   for (Person person : people) {
     //       if (name.equals(person.getName())) {
     //           person.buyFood();
     //       }
     //   }
//
    }
}
