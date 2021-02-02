import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ALL_CAPITALS_EXERCISE_3 {
    public static void main(String[] args) {

        List<String> strings;

        try {
            FileWriter fileWriter=new FileWriter(new File("test.txt"));
            strings= Files.readAllLines(Path.of("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));

            for (String s : strings) {
                fileWriter.write(s.toUpperCase() + "\n");
                fileWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
