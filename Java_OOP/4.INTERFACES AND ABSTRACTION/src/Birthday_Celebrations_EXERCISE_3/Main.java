package Birthday_Celebrations_EXERCISE_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String input = Scanner.nextLine();

        List<String> dates = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String date="";
            switch (type) {

                case "Citizen":
                    date= tokens[4];
                    dates.add(date);
                    break;
                case "Pet":
                    date=tokens[2];
                    dates.add(date);
                    break;
            }


            input = Scanner.nextLine();
        }

        int birth=Integer.parseInt(Scanner.nextLine());

        List<Integer> checkIfIsEmpty=new ArrayList<>();

        for (String date : dates) {
            String[] allDate=date.split("/");
            int dateForCheck=Integer.parseInt(allDate[2]);
            if (dateForCheck==birth) {
                System.out.println(date);
                checkIfIsEmpty.add(dateForCheck);
            }
        }

        if (checkIfIsEmpty.size() ==0) {
            System.out.println("<no output>");
        }


    }
}
