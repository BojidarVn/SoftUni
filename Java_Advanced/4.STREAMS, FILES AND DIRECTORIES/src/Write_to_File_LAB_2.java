import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Write_to_File_LAB_2 {
    public static void main(String[] args) throws IOException {
      //  Scanner Scanner = new Scanner(System.in);

        File file=new File("F:\\Bobi\\softuni\\Advance JAVA\\Stream file and directories\\input.txt");

        FileInputStream inputStream=new FileInputStream(file);

        Scanner Scanner=new Scanner(inputStream);

        StringBuilder builder=new StringBuilder();
        String line="";

        while (line != null) {

            builder.append(line.replaceAll("[,\\.!\\?]","")).append(System.lineSeparator());
            try {

                line=Scanner.nextLine();
            } catch (NoSuchElementException ex) {
                inputStream.close();
                break;
            }

        }

        String string = builder.toString();

        OutputStream outputStream=new FileOutputStream("output.txt");

        PrintWriter printWriter=new PrintWriter(outputStream);

        printWriter.print(string);

        printWriter.close();

    }
}
