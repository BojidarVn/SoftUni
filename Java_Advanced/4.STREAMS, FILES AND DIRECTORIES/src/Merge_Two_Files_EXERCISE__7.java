import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merge_Two_Files_EXERCISE__7 {
    public static void main(String[] args) {

        Map<String, Integer> wordsAndCount = new HashMap<>();
        try {
            List<String> fileOne = Files.readAllLines(Path.of("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt"));
            List<String> fileTwo = Files.readAllLines(Path.of("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"));
            FileWriter fileWriter = new FileWriter(new File("test.txt"));
            for (String s : fileOne) {
                fileWriter.write(s + "\n");
                fileWriter.flush();
            }

            for (String s : fileTwo) {
                fileWriter.write(s + "\n");
                fileWriter.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
