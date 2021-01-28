import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_of_2X2_Submatrix_lab_5 {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);


        int[] size = Arrays.stream(Scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();


        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(Scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        }


        int maxValue = Integer.MIN_VALUE;

       // int[][] maxMatrix=new int[2][2];        tova e purviq na4in

        int row=-1;
        int col=-1;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {

                int current = matrix[r][c];
                int right = matrix[r][c + 1];
                int below = matrix[r + 1][c];
                int diagonal = matrix[r + 1][c + 1];

                int sum = current + right + below + diagonal;

                if (sum > maxValue) {
                    maxValue = sum;

                    row=r;
                    col=c;

                //   maxMatrix[0][0]= current;
                //   maxMatrix[0][1]= right;
                //   maxMatrix[1][0]= below;
                //   maxMatrix[1][1]=diagonal;

                }

            }
        }

     //  for (int i = 0; i < 2; i++) {
     //      for (int j = 0; j < 2; j++) {
     //          System.out.print(maxMatrix[i][j] + " ");

     //      }
     //      System.out.println();
     //  }


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[row+i][col+j] + " ");
            }
            System.out.println();
        }


        System.out.println(maxValue);


    }
}
