package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPosition(scanner.nextLine());

//        Field field = new Field(dimensions[0], dimensions[1]); tova e v skobite na galaxy

        Galaxy galaxy=new Galaxy( new Field(dimensions[0], dimensions[1]));

        String positions = scanner.nextLine();

        long starPowerCollected = 0;

        while (!positions.equals("Let the Force be with you")) {



            int[] jadiPositions = readPosition(positions);

            int[] sithPosition = readPosition(scanner.nextLine());

            int rowJadi = jadiPositions[0];
            int colJadi = jadiPositions[1];

            int rowSith = sithPosition[0];
            int colSith = sithPosition[1];

            galaxy.movieSith(rowSith,colSith);

           starPowerCollected+= galaxy.movieJedi(rowJadi,colJadi);

            positions = scanner.nextLine();
        }

        System.out.println(starPowerCollected);


    }



    private static int[] readPosition(String positions) {
        return Arrays
                .stream(positions.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
