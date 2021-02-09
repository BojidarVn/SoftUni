package Pokemon_Trainer__EXERCISE__6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String line = Scanner.nextLine();

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String name = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName);

            Pokemon pokemon = new Pokemon(name, element, health);

            trainerMap.putIfAbsent(trainerName, trainer);
            trainerMap.get(trainerName).addPokemon(pokemon);

            line = Scanner.nextLine();
        }

        line = Scanner.nextLine();

        while (!line.equals("End")) {

            String element = line;

            for (Trainer trainer : trainerMap.values()) {
                if (trainer.hasElementType(element)) {
                    trainer.incrementBadges(1);
                } else {
                    trainer.damagePokemones(10);

                }
            }

            line = Scanner.nextLine();
        }
        trainerMap
                .entrySet()
                .stream()
                .sorted((f,s) ->{
                    return s.getValue().getBadges() - f.getValue().getBadges();
                })
                .forEach(e -> {
                    System.out.println(e.getValue().toString());
                });

    }

}
