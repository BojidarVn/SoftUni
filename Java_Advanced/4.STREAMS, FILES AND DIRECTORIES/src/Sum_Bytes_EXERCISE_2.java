import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Sum_Bytes_EXERCISE_2 {
    public static void main(String[] args) {

        try {

            List<String> strings = Files.readAllLines(Paths.get("F:\\Bobi\\softuni\\Advance JAVA\\Stream file and directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            long asciiSum=0;
            for (String string : strings) {

                for (int i = 0; i < string.length(); i++) {
                    asciiSum+=string.charAt(i);
                }



            }
            System.out.println(asciiSum);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
