package Pokemon_Trainer__EXERCISE__6_second_try;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String line = Scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String name = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName);

            Pokemon pokemon = new Pokemon(name, element, health);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);

            line = Scanner.nextLine();
        }

        line = Scanner.nextLine();

        while (!line.equals("End")) {
            String element = line;

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(element)) {
                    trainer.incrementBadges(1);
                } else {
                    trainer.damagePokemons(10);
                }
            }


            line = Scanner.nextLine();
        }
        System.out.println();


    }
}
