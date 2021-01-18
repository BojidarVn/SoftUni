package Wild_Farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String line = Scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!line.equals("End")) {
            String[] animalTokens = line.split("\\s+");


            Animal animal;
            String type = animalTokens[0];
            String name = animalTokens[1];
            Double weight = Double.parseDouble(animalTokens[2]);
            String livingRegion = animalTokens[3];

            switch (type) {
                case "Mouse":
                    animal = new Mouse(name, type, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(name, type, weight, livingRegion);
                    break;
                case "Cat":
                    animal = new Cat(name, type, weight, livingRegion, animalTokens[4]);
                    break;
                default:
                    animal = new Tiger(name, type, weight, livingRegion);
                    break;
            }
            animals.add(animal);

            String[] foodTokens = Scanner.nextLine().split("\\s+");

            int quantity = Integer.parseInt(foodTokens[1]);

            Food food = foodTokens[0].equals("Meat")
                    ? new Meat(quantity)
                    : new Vegetable(quantity);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            line = Scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
