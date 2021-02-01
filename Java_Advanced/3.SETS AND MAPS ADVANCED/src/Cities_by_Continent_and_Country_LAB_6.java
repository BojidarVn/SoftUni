import java.util.*;

public class Cities_by_Continent_and_Country_LAB_6 {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        Map<String, Map<String, List<String>>> earth = new LinkedHashMap<>();

        while (n-- > 0) {

            String[] tokens = Scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!earth.containsKey(continent)) {
                earth.put(continent, new LinkedHashMap<>());
                earth.get(continent).put(country, new ArrayList<>());

            } else {
                if (!earth.get(continent).containsKey(country)) {
                    earth.get(continent).put(country,new ArrayList<>());
                }
            }
            earth.get(continent).get(country).add(city);
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : earth.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Map.Entry<String, List<String>> inner : entry.getValue().entrySet()) {
                System.out.println(" "+ inner.getKey()+" -> " + String.join(", ",inner.getValue()));

            }
        }

    }
}
