import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class read_file_LAB_1 {
    public static void main(String[] args) throws IOException {
        Scanner Scanner = new Scanner(System.in);


        //  String path="input.txt";
        //       try (FileInputStream fileStream=new FileInputStream(path)) {
//
        //       } catch (IOException e) {
        //           e.printStackTrace();
        //       }
//
        //       try (FileInputStream fileStream=new FileInputStream(path)) {
        //           int oneByte=fileStream.read();
        //           while (oneByte>=0) {
        //               System.out.printf("%s ",Integer.toBinaryString(oneByte));
        //               oneByte=fileStream.read();
        //           }
//
        //   } catch (IOException e) {
        //       e.printStackTrace();
        //   }

        // vtori na4in
        Path path = Path.of("Input.txt");
        // dali s dolniq red ili bez nego vse taq
        File file = new File("F:\\Bobi\\softuni\\Advance JAVA\\Stream file and directories\\input.txt");

        byte[] bytes = Files.readAllBytes(path);

        for (byte b : bytes) {
            System.out.print(Integer.toBinaryString(b) + " ");
        }

    }
}
