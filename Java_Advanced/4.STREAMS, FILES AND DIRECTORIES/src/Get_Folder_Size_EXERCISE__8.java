import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Get_Folder_Size_EXERCISE__8 {
    public static void main(String[] args) {

        try {
            FileWriter fileWriter=new FileWriter(new File("test.txt"));
            File file=new File("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");

            int size=0;
            for (File currentFile : file.listFiles()) {
              //  byte[] bytes=currentFile.toString().getBytes();
              //  for (byte aByte : bytes) {
              //      size+=aByte;
              //  }
                size+=currentFile.length();
            }
            System.out.println(size);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
