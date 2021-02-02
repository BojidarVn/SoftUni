import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write_Every_Third_Line_LAB_5 {
    public static void main(String[] args) throws IOException {


        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("F:\\Bobi\\softuni\\Advance JAVA\\Stream file and directories\\outputZad6.txt");

     try ( BufferedReader in = new BufferedReader(new FileReader(String.valueOf(inputPath)));
        PrintWriter out = new PrintWriter(new FileWriter(String.valueOf(outputPath)))) {
         int counter=1;
         String line=in.readLine();
         while (line != null) {
             if (counter %3 ==0) {
                 out.println(line);
             }
             counter++;
             line=in.readLine();
         }

     }


    }
}
