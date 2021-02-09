package Car_Salesman_EXERCISE_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int n = Integer.parseInt(Scanner.nextLine());

        Map<String, Engine> engineMap = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = Scanner.nextLine().split("\\s+");


            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;

            if (tokens.length == 2) {
                engine = new Engine(model, power);

            } else if (tokens.length == 4) {

                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);

            } else {

                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException ex) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engineMap.put(model, engine);
        }

        n = Integer.parseInt(Scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = Scanner.nextLine().split("\\s+");

            //"<Model> <Engine> <Weight> <Color>",

            String model = tokens[0];
            String engineModel = tokens[1];

            Car car;

            if (tokens.length == 2) {
                car = new Car(model, engineMap.get(engineModel));
            } else if (tokens.length == 4) {
                car = new Car(model, engineMap.get(engineModel), Integer.parseInt(tokens[2]), tokens[3]);
            } else {

                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engineMap.get(engineModel), weight);
                } catch (NumberFormatException ex) {
                    car = new Car(model, engineMap.get(engineModel), tokens[2]);
                }
            }
            cars.add(car);
        }

cars.forEach(System.out::println);

    }
}
