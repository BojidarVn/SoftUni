import java.util.*;

public class Periodic_Table_Exercise_3 {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        Set<String> periodicTable = new TreeSet<>();

        for (int i = 0; i < n; i++) {

            String[] elements = Scanner.nextLine().split("\\s+");


            // za4ernenoto stava reda po dolo
            // for (String element:elements) {
            //                periodicTable.add(element);
            //
            //     }

            periodicTable.addAll(Arrays.asList(elements));
        }

        System.out.print(String.join(" ",periodicTable));

        }
    }

