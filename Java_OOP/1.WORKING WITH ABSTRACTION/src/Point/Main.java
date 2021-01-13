package Point;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        Point bottomLeft=createPointReadingTwoIntsFrom(Scanner);
        Point topRight=createPointReadingTwoIntsFrom(Scanner);

        Rectangle rectangle=new Rectangle(bottomLeft,topRight);


    //  int bottomLeftX = Scanner.nextInt();
    //  int bottomLeftY = Scanner.nextInt();
    //  int topRightX = Scanner.nextInt();
    //  int topRightY = Scanner.nextInt();

    //   Rectangle rectangle = new Rectangle(
    //           new Point(bottomLeftX, bottomLeftY),
    //           new Point(topRightX, topRightY)
    //   );

        int numbersOfPoints = Scanner.nextInt();

        for (int i = 0; i < numbersOfPoints; i++) {


            Point point = createPointReadingTwoIntsFrom(Scanner);
            System.out.println(rectangle.contains(point));
        }


    }

    private static Point createPointReadingTwoIntsFrom(Scanner Scanner) {
        int pointX = Scanner.nextInt();
        int pointY = Scanner.nextInt();

        return new Point(pointX, pointY);
    }
}
