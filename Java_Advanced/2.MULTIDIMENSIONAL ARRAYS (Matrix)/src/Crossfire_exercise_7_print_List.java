import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire_exercise_7_print_List {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);  //zada4ata ima 90 to4ki nz za6to

        int[] dimension = Arrays.stream(Scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                numbers.add(counter++);
            }
            matrix.add(numbers);
        }

        String command = "";

        while (!(command = Scanner.nextLine()).equals("Nuke it from orbit")) {

            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int targetRow = tokens[0];
            int targetCol = tokens[1];
            int radius = tokens[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isValid(row, targetCol, matrix)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isValid(targetRow, col, matrix)) {
                    matrix.get(targetRow).set(col, 0);
                }

            }

            for (int i = 0; i < matrix.size(); i++) {
                //  matrix.get(i).removeAll(List.of(0));
                matrix.get(i).removeAll(new ArrayList<Integer>() {{
                    add(0);
                }});

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }

            //  System.out.println();
        }

        printMatrix(matrix);
    }

    private static boolean isValid(int row, int targetCol, List<List<Integer>> matrix) {
        return (row >= 0 && row < matrix.size()) && (targetCol >= 0 && targetCol < matrix.get(row).size());
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }
}
