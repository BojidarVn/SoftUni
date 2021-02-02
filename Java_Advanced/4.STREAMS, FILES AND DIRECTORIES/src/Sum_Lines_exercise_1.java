import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Sum_Lines_exercise_1 {
    public static void main(String[] args) {

// List<String> strings; taka se suzdava i mahame list<String> vutre v try konstrykciqta
    try {
        //tova e za peratane kato my poso4vame kude da pe4ata
        FileWriter fileWriter=new FileWriter(new File("test.txt"));
        List<String> strings = Files.readAllLines(Paths.get("F:\\Bobi\\softuni\\Advance JAVA\\Stream file and directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        for (String string : strings) {
            long asciiSum=0;
            for (int i = 0; i < string.length(); i++) {
                asciiSum+=string.charAt(i);
            }
            System.out.println(asciiSum);
            //dolnite dva reda sa za pe4atane vuv fail
            fileWriter.write(asciiSum + "\n");
            fileWriter.flush();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }



    }
}
