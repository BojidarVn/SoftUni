import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

    //  int[][] matrix = new int[][]{
    //          {1, 2, 3, 4,5,6,7,8},
    //          {1, 2, 3, 8}
    //  };

    ////  int test = matrix[1][3];


    //  for (int row  = 0;row < matrix.length; row++) {
    //     // int[] arr=matrix[row];
    //      for (int col = 0; col <matrix[row].length ; col++) {
    //          System.out.print(matrix[row][col] + ", ");
    //      }
    //      System.out.println();
    //  }

        //Matrix_of_Palindromes_exercise_2

      // System.out.println(test);
      // System.out.println(Arrays.toString(matrix[0]));


        int rows =Integer. parseInt(Scanner.nextLine());
        int cols =Integer.parseInt(Scanner.nextLine());

        int[][] matrix=new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputTokens=Scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=Integer.parseInt(inputTokens[col]);
            }
        }

        System.out.println();
    }
}
