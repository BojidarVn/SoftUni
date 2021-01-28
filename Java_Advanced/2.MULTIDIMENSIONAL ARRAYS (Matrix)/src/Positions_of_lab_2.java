import java.util.Scanner;

public class Positions_of_lab_2 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int rows = Scanner.nextInt();
        int cols = Scanner.nextInt();

     //   Scanner.nextLine();   tova e ako polzvane na purviq na4in

int [][] matrix=new int[rows][cols];


// purvi na4in
     //   for (int i = 0; i < rows; i++) {
     //       matrix[i]= Arrays.stream(Scanner.nextLine().split("\\s+"))
     //               .mapToInt(Integer::parseInt)
     //               .toArray();
     //
     //   }

        // vtori na4in

        for (int i = 0; i < rows; i++) {
                for (int j = 0; j <cols ; j++) {
                matrix[i][j]=Scanner.nextInt();
            }
        }

        int number =Scanner.nextInt();

        boolean numberIsPresent= false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == number) {
                    System.out.println(r + " " + c);
                    numberIsPresent=true;
                }
            }

        }

        if (!numberIsPresent) {
            System.out.println("not found");
        }

     //   System.out.println();
    }
}
