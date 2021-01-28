import java.util.Scanner;

public class Matrix_of_Palindromes_exercise_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        String[][] matrix = new String[rows][cols];

        char startSymbol = 97;
        for (int row = 0; row < rows; row++) {
            char middleSymbol = startSymbol;

            for (int col = 0; col < cols; col++) {
                StringBuilder result = new StringBuilder(3);
                result.append(startSymbol).append(middleSymbol).append(startSymbol);
                matrix[row][col] = result.toString();
                result.setLength(0);
                middleSymbol++;
            }

            startSymbol++;
        }
        System.out.println();
        printCharMatrix(matrix);
    }

    private static void printCharMatrix(String[][] finalMatrix) {
        for (String[] matrix : finalMatrix) {
            for (String element : matrix) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}