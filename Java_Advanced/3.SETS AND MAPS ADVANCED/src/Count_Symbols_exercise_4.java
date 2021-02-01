import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Symbols_exercise_4 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String input = Scanner.nextLine();

        Map<Character, Integer> dictionary = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!dictionary.containsKey(symbol)) {
                dictionary.put(symbol, 1);
            } else {
                int count = dictionary.get(symbol) + 1;
                dictionary.put(symbol, count);
            }
        }

        for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
            System.out.printf("%c: %d time/s\n",entry.getKey(),entry.getValue());
        }

    }
}
