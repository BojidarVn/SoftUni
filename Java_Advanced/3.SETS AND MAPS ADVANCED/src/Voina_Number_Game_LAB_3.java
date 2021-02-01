import java.util.*;
import java.util.stream.Collectors;

public class Voina_Number_Game_LAB_3 {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        Set<Integer> firstPayer = Arrays.stream(Scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPayer = Arrays.stream(Scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        int round = 50;

        while (round-- > 0) {

            Iterator<Integer> firstIterator = firstPayer.iterator();
            int firstCard = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondPayer.iterator();
            int secondCard = secondIterator.next();
            secondIterator.remove();


            if (firstCard > secondCard) {
                firstPayer.addAll(Arrays.asList(firstCard, secondCard));     // tova e vkarva6 list direktno (рапваме го)
            } else if(firstCard < secondCard) {
                secondPayer.addAll(Arrays.asList(firstCard, secondCard));
            }

            if (firstPayer.isEmpty() || secondPayer.isEmpty()) {
                break;
            }
        }

        String output = "Draw!";

        if (firstPayer.size() < secondPayer.size()) {
            output = "Second player win!";
        } else if (firstPayer.size() > secondPayer.size()) {
            output = "First player win!";
        }
        System.out.println(output);

    }


}
