import java.util.Scanner;

public class String_Matrix_Rotation_exercise_6 {

    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        //   String[] rotations =Scanner.nextLine().split("[\\(\\)]");
        int rotations = Integer.parseInt(Scanner.nextLine().split("[\\(\\)]")[1]);

        int maxLength = 0;

        String line = "";
        String input;
        while (!(input = Scanner.nextLine()).equals("END")) {

            line += input + "\n";

            if (input.length() > maxLength) {
                maxLength = input.length();
            }

        }

        String[] matrix = line.split("\n");

        String output="";

        rotations %= 360;
         System.out.println();
        switch (rotations) {
            case 0:
                //System.out.println(line);
                System.out.println(String.join("\n", matrix));
                break;
            case 90:
                for (int r = 0; r < maxLength; r++) {
                    for (int c = matrix.length-1; c >=0; c--) {


                        try {
                            output+=matrix[c].charAt(r);
                        } catch (Exception e) {
                            output+=" ";

                        }

                    }
                   output+="\n";
                }
                System.out.println(output);
                break;
            case 180:
                System.out.println(new StringBuilder(line).reverse());
                break;
            case 270:
                for (int r = 0; r < maxLength; r++) {
                    for (int c = matrix.length - 1; c >= 0; c--) {


                        try {
                            output += matrix[c].charAt(r);
                        } catch (Exception e) {
                            output += " ";

                        }

                    }
                    output += "\n";
                }

                System.out.println(new StringBuilder(output).reverse());
                break;
        }


//        System.out.println(line);
//        System.out.println(maxLength);
    }

}
