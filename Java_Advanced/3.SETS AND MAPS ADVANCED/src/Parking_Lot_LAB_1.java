import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Parking_Lot_LAB_1 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String input = Scanner.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String command = input.substring(0, input.indexOf(", "));
            String registration = input.substring(input.indexOf(", ") + 2);

            if (command.equals("IN")) {
                carNumbers.add(registration);
            } else {
                carNumbers.remove(registration);
            }
            input = Scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join("\n", carNumbers));
        }
    }
}
