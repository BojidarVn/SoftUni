package BorderControl;

import BorderControl.Citizen;
import BorderControl.Identifiable;
import BorderControl.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String line=Scanner.nextLine();

        List<Identifiable> identifiables=new ArrayList<>();

        while (!line.equals("End")) {

            String[] tokens=line.split("\\s+");

            Identifiable current;

            if (tokens.length== 3) {
              current= new  Citizen (tokens[2],Integer.parseInt(tokens[1]), tokens[0]);

            } else {
                current= new Robot(tokens[1],tokens[0]);

            }

            identifiables.add(current);

            line=Scanner.nextLine();
        }

        String fakeIdEndPattern=Scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeIdEndPattern)) {
                System.out.println(identifiable.getId());
            }
        }


    }
}
