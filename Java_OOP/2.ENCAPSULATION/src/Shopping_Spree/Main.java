package Shopping_Spree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String[] personsInput = Scanner.nextLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();

        for (String in : personsInput) {
            String[] tokens = in.split("=");
            people.putIfAbsent(tokens[0],
                    new Person(tokens[0], Double.parseDouble(tokens[1])));
        }

        String[] productInput = Scanner.nextLine().split(";");
        Map<String, Product> products = new LinkedHashMap<>();

        for (String in : productInput) {
            String[] tokens = in.split("=");
            products.putIfAbsent(tokens[0],
                    new Product(tokens[0], Double.parseDouble(tokens[1])));
        }

        String line;

        while (!(line = Scanner.nextLine()).equals("END")) {
            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            String productName = tokens[1];

            if (people.containsKey(personName) && products.containsKey(productName)) {

                Person person = people.get(personName);
                Product product = products.get(productName);

                person.buyProduct(product);
            }

        }

        for (Person person : people.values()) {
            System.out.println(person);
        }

    }
}
