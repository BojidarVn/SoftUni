import java.util.Arrays;
import java.util.Scanner;

public class Sum_Matrix_Elements_lab_4 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int[] input = Arrays.stream(Scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int row = input[0];
        int col = input[1];

        int[][] matrix = new int[row][col];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            String[] tokens=Scanner.nextLine().split(",\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=Integer.parseInt(tokens[j]);
            }
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum+=matrix[i][j];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[row-1].length);
        System.out.println(sum);

    }
}
