import java.util.Scanner;

public class Diagonal_Difference_exercise_3 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);


        int size = Integer.parseInt(Scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Scanner.nextInt();

            }
        }
        int mainDiagonal = getMainDiagonalSum(matrix);
        int secondaryDiagonal = getSecondaryDiagonalSum(matrix);
        int sum = Math.abs(mainDiagonal - secondaryDiagonal);
        System.out.println(sum);
        //  System.out.println(secondaryDiagonal);

    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int r = matrix.length-1;
        int c = 0;

        while (r >= 0 && c < matrix[r].length) {
            sum += matrix[r--][c++];
            if (r < 0) {
                break;
            }
        }

        return sum;
    }

    private static int getMainDiagonalSum(int[][] matrix) {
        int sum = 0;
        int r = 0, c = 0;

        while (r < matrix.length && c < matrix[r].length) {
            sum += matrix[r++][c++];
        }


        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }


}
