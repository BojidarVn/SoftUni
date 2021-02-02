import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Line_Numbers_EXERCISE__5 {
    public static void main(String[] args) {

        try {
            FileWriter fileWriter=new FileWriter(new File("test.txt"));
            List<String> strings= Files.readAllLines(Path.of("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));

            for (int i = 0; i < strings.size(); i++) {
                fileWriter.write(String.format("%d. %s%n",i+1,strings.get(i)));
                fileWriter.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
