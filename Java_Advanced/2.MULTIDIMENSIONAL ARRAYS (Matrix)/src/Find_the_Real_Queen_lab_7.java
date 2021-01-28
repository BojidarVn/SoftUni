import java.util.Scanner;

public class Find_the_Real_Queen_lab_7 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int size = 8;

        char[][] bord = new char[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = Scanner.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                bord[i][j] = line[j].charAt(0);

            }
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (bord[r][c] == 'q') {

                    boolean isColValid = checkQueenCol(bord, c);
                    boolean isRowValid = checkQueenRow(bord, r);

                    boolean isMainDiagonalValidUpAndLeft = checkMainDiagonalUpLeft(bord, r, c);
                    boolean isMainDiagonalValidDownAndRight = checkMainDiagonalDownAndRight(bord, r, c);

                    boolean isSecondDiagonalValidUpAndRight = checkSecondDiagonalValidUpAndDown(bord, r, c);
                    boolean isSecondDiagonalValidDownLeft = checkSecondDiagonalDownLeft(bord, r, c);

                    if(isColValid && isRowValid && isMainDiagonalValidDownAndRight && isMainDiagonalValidUpAndLeft
                    && isSecondDiagonalValidDownLeft && isSecondDiagonalValidUpAndRight) {
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }
        }


        //       System.out.println();


    }

    private static boolean checkSecondDiagonalDownLeft(char[][] bord, int row, int col) {
        row++;
        col--;

        while (row<8 && col>=0) {
            if (bord[row++][col--] == 'q') {
                return false;
            }

        }
        return true;

    }

    private static boolean checkSecondDiagonalValidUpAndDown(char[][] bord, int row, int col) {

        row--;
        col++;

        while (row >= 0 && col < 8) {
            if (bord[row--][col++] == 'q') {
                return false;
            }

        }
        return true;


    }

    private static boolean checkMainDiagonalDownAndRight(char[][] bord, int row, int col) {

        row++;
        col++;

        while (row < 8 && col < 8) {
            if (bord[row++][col++] == 'q') {
                return false;
            }
        }
        return true;


    }

    private static boolean checkMainDiagonalUpLeft(char[][] bord, int row, int col) {

        row--;
        col--;

        while (row >= 0 && col >= 0) {
            if (bord[row--][col--] == 'q') {
                return false;
            }
        }
        return true;


    }

    private static boolean checkQueenRow(char[][] bord, int row) {
        int queen = 0;

        for (int i = 0; i < bord.length; i++) {
            char symbol = bord[row][i];
            if (symbol == 'q') {
                queen++;
            }
        }
        return queen == 1;


    }

    private static boolean checkQueenCol(char[][] bord, int col) {
        int queen = 0;

        for (int i = 0; i < bord.length; i++) {
            char symbol = bord[i][col];
            if (symbol == 'q') {
                queen++;
            }
        }
        return queen == 1;

    }
}
