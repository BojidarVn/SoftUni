
package workingWithAbstraction.greedyTimes;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        Treasure treasure = new Treasure(scanner.nextLine().split("\\s+"));

        Bag bag = new Bag(capacity);

        for (var pair : treasure) {
            String first = pair.getFirst();
            Long value = pair.getSecond();


            String type = null;

            if (first.length() == 3) {
                type = "Cash";
            } else if (first.toLowerCase().endsWith("gem")) {
                type = "Gem";
            } else if (first.toLowerCase().equals("gold")) {
                type = "Gold";
            }
            if (bag.hasRoomFor(value) && type !=null) {


            }
        }
   // switch (type) {
   //     case "Gem":
   //         if (!torba.containsKey(type)) {
   //             if (torba.containsKey("Gold")) {
   //                 if (broika > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
   //                     continue;
   //                 }
   //             } else {
   //                 continue;
   //             }
   //         } else if (torba.get(type).values().stream().mapToLong(e -> e).sum() + broika > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
   //             continue;
   //         }
   //         break;
   //     case "Cash":
   //         if (!torba.containsKey(type)) {
   //             if (torba.containsKey("Gem")) {
   //                 if (broika > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
   //                     continue;
   //                 }
   //             } else {
   //                 continue;
   //             }
   //         } else if (torba.get(type).values().stream().mapToLong(e -> e).sum() + broika > torba.get("Gem").values().stream().mapToLong(e -> e).sum()) {
   //             continue;
   //         }
   //         break;
   // }

   // if (!torba.containsKey(type)) {
   //     torba.put((type), new LinkedHashMap<String, Long>());
   // }

   // if (!torba.get(type).containsKey(name)) {
   //     torba.get(type).put(name, 0L);
   // }


   // torba.get(type).put(name, torba.get(type).get(name) + broika);


   // for (var x : torba.entrySet()) {
   //     Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

   //     System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

   //     x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

    }

}