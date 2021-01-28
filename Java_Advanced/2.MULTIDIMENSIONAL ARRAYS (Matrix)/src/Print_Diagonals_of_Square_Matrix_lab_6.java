import java.util.Arrays;
import java.util.Scanner;

public class Print_Diagonals_of_Square_Matrix_lab_6 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

int size=Integer.parseInt(Scanner.nextLine());

int[][] matrix =new int[size][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i]= Arrays.stream(Scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }


        int row=0;
        int col=0;

        while (row<size && col<size) {

            int element= matrix[row++][col++];
            System.out.print(element + " ");

        }

        row=size-1;
        col=0;
        System.out.println();

        while (row>= 0 && col<size) {

            int element= matrix[row][col];
            System.out.print(element + " ");

// tyka moje da se sloji kato v gorniq q while
            
            row--;
            col++;
        }

    }
}
