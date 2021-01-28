import java.util.Arrays;
import java.util.Scanner;

public class Compare_Matrices_lab_1 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        // int[] dimentions = readRowsAndColumns(Scanner);

        int[] rowsAndCols = Arrays.stream(Scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] firstMatrix=readMatrix(Scanner, rows,cols);


        rowsAndCols = Arrays.stream(Scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int[][] secondMatrix=readMatrix(Scanner, rows,cols);

        if(areMatrixEqual(firstMatrix,secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }


        System.out.println();
    }

    private static boolean areMatrixEqual(int[][] firstMatrix, int[][] secondMatrix) {
        boolean areEqual=true;

        if (firstMatrix.length != secondMatrix.length) {
            areEqual=false;
        } else {

            for (int r = 0; r < firstMatrix.length; r++) { // nqma zna4enie koq matrica pishem


                if (firstMatrix[r].length != secondMatrix[r].length) {
                    areEqual =false;
                    break;
                } else {
                    for (int c = 0; c < firstMatrix[r].length; c++) {    // ili first tova se otnasq i za gorniq for cikul
                        if (firstMatrix[r] [c] != secondMatrix[r] [c]) {
                            return false;

                        }
                    }
                }
            }
        }


        return areEqual;
    }

    private static int[][] readMatrix(Scanner Scanner, int row,int col) {
        int[][] matrix=new int[row][col];
        for (int r = 0; r < row; r++) {
            String[] elements = Scanner.nextLine().split(" ");
            for (int c = 0; c < elements.length; c++) {
                int number=Integer.parseInt(elements[c]);
                matrix[r][c]=number;
            }
        }

        return matrix;
    }
}
