package Food_Shortage_EXERCISE_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int N = Integer.parseInt(Scanner.nextLine());

        Map<String, Buyer> buyersByNames = new HashMap<>();

        while (N-- > 0) {
            Buyer buyer = createBuyer(Scanner.nextLine());
            buyersByNames.put(buyer.getName(), buyer);
        }

        String line = Scanner.nextLine();

        while (!line.equals("End")) {

            Buyer buyer = buyersByNames.get(line);

            if (buyer != null)
                buyer.buyFood();

            line = Scanner.nextLine();
        }

        System.out.println(buyersByNames.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }

    private static Buyer createBuyer(String input) {
        String[] tokens = input.split("\\s+");

        if (tokens.length == 4) {
            return new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
        }
        return new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
    }
}
