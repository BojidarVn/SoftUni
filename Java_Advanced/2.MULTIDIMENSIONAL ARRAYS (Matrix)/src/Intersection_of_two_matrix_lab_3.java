import java.util.Scanner;

public class Intersection_of_two_matrix_lab_3 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);


        int rows=Integer.parseInt(Scanner.nextLine());
        int cols=Integer.parseInt(Scanner.nextLine());



char[][] firstMatrix=new char[rows][cols];

// purvi na4in
   //  for (int i = 0; i < rows; i++) {
   //      for (int j = 0; j < cols; j++) {
   //          firstMatrix[i][j]=(char) Scanner.nextInt();
   //
   //      }
   //  }

        // vtori naìn

        for (int i = 0; i < rows; i++) {
            String[] line=Scanner.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                firstMatrix[i][j]=line[j].charAt(0);
            }

        }

        System.out.println();

char[][] secondMatrix=new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line=Scanner.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                secondMatrix[i][j]=line[j].charAt(0);
            }

        }

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {

                if(firstMatrix[r][c] != secondMatrix[r][c]) {
                    firstMatrix[r][c]='*';
                }

            }

        }


        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                System.out.print(firstMatrix[r][c] + " ");
            }
            System.out.println();
        }


    }
}
