import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Count_Character_Types_EXERCISE__4 {
    public static void main(String[] args) {

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;

        try {
            String file = String.join("", Files.readAllLines(Path.of("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt")));
            FileWriter fileWriter=new FileWriter(new File("test.txt"));

            for (int i = 0; i < file.length(); i++) {
                char symbol = file.charAt(i);

                if (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'u' || symbol == 'i') {
                    countVowels++;
                } else if (Character.isLetterOrDigit(symbol) || symbol=='-' || symbol=='\'' ) {
                    countConsonants++;
                } else if (symbol == '!' || symbol == '?' || symbol == ',') {
                    countPunctuation++;
                }

            }

            fileWriter.write(String.format("Vowels: %d\nConsonants: %d\nPunctuation: %d",
                    countVowels,countConsonants,countPunctuation));
            fileWriter.flush();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
