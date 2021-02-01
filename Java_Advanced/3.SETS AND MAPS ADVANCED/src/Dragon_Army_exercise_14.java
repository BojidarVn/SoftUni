import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dragon_Army_exercise_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();

        while (num-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int[] data = new int[3];
            data[0] = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            data[1] = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            data[2] = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);


            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }

            dragons.get(type).putIfAbsent(name, data);
            dragons.get(type).put(name, data);
        }
        dragons.forEach((key, value) -> {
            double[] avg = new double[3];
            value.forEach((k, v) -> {
                avg[0] += v[0];
                avg[1] += v[1];
                avg[2] += v[2];
            });
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", key, avg[0] / value.size()
                    , avg[1] / value.size(), avg[2] / value.size()));

            value.forEach((k, v) -> {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                        k, v[0], v[1], v[2]));
            });
        });

    }
}