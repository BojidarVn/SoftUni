import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire_zada4a_s_vhod_list_exercise_7 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

         List<List<Integer>> matrix=readMatrix(Scanner);
    }

    private static List<List<Integer>> readMatrix(Scanner Scanner) {
        int[] rowsAndCols= Arrays.stream(Scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows=rowsAndCols[0];
        int cols=rowsAndCols[1];

        List<List<Integer>> matrix= new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            ArrayList<Integer> list =Arrays.stream(Scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            matrix.add(list);

            // drygi na4ini za zapis na purvoto

//            ArrayList<Integer> list =Arrays.stream(Scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .boxed()
//                    .collect(Collectors.toCollection(ArrayList::new));

  //                  matrix.add(Arrays.stream(Scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .boxed()
//                    .collect(Collectors.toCollection(ArrayList::new)));
        }
//The_Heigan_Dance_exercise_8

        return matrix;
    }
}
