import java.util.*;
import java.util.stream.Collectors;

public class Average_Students_Grades_LAB_5 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        Map<String, List<Double>> studentsWithGrade = new TreeMap<>();

        while (n-- > 0) {

            String[] tokens = Scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsWithGrade.putIfAbsent(name, new ArrayList<>());
            studentsWithGrade.get(name).add(grade);
        }

        // sortirane
      // studentsWithGrade.entrySet().stream()
      //         .sorted((f, s) -> getAvgGrade(s.getValue()).compareTo(getAvgGrade(f.getValue())))
      //                 .forEach(entry -> {
      //                     System.out.println(String.format("%s -> %s (avg: %.2f)",entry.getKey(),
      //                             getGradesAsString(entry.getValue()), getAvgGrade(entry.getValue())));
      //                 });

                // dryg na4in ma sortirane s comparator
        studentsWithGrade.entrySet().stream()
                .sorted(Comparator.comparingDouble(entry -> getAvgGrade(entry.getValue())))
                .forEach(entry -> {
                    System.out.println(String.format("%s -> %s (avg: %.2f)",entry.getKey(),
                            getGradesAsString(entry.getValue()), getAvgGrade(entry.getValue())));
                });



        for (Map.Entry<String, List<Double>> entry : studentsWithGrade.entrySet()) {
            System.out.println(String.format("%s -> %s (avg: %.2f)",entry.getKey(),
                    getGradesAsString(entry.getValue()), getAvgGrade(entry.getValue())));
        }

    }

    private static Double getAvgGrade(List<Double> grades) {
        return grades
                .stream()
                .mapToDouble(g ->g)
                .average().orElse(0.00);
    }

    private static String getGradesAsString(List<Double> grades) {
        return grades
                .stream()
                .map(grade -> String.format("%.2f",grade))
                .collect(Collectors.joining(" "));
    }
}
