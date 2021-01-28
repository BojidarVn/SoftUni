import java.util.Arrays;
import java.util.Scanner;

public class Matrix_shuffling_exercise_5 {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(Scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int row = dimension[0];
        int col = dimension[1];

        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = Scanner.nextLine().split("\\s+");
        }

        String line;

        while (!(line = Scanner.nextLine()).equals("END")) {

            String[] tokens = line.split("\\s+");


            if (!(tokens[0]).equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (row1 < 0 || row1 > matrix.length || col1 < 0 || col1 > matrix[0].length
                    || row2 < 0 || row2 > matrix.length || col2 < 0 || col2 > matrix[0].length) {

                System.out.println("Invalid input!");
                continue;

            }

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            printMatrix(matrix);
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

}
