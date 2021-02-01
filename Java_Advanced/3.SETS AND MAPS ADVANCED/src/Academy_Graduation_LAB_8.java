import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Academy_Graduation_LAB_8 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        Map<String, List<Double>> graduation = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = Scanner.nextLine();
            List<Double> grade = Arrays.stream(Scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());

            graduation.putIfAbsent(name, new ArrayList<>());
            graduation.get(name).addAll(grade);
        }


       graduation.forEach((name,grade) ->{
           double sum2=0;
           for (Double gr: grade) {
               sum2+=gr;
           }
           double avg=sum2/grade.size();
           System.out.println(String.format("%s is graduated with %s",name,avg));
       });



    }
}
