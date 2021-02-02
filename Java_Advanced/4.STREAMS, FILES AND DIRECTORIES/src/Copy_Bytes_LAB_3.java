import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

public class Copy_Bytes_LAB_3 {
    public static void main(String[] args) throws IOException {

        File file = new File("input.txt");

        byte[] bytes = Files.readAllBytes(file.toPath());

        Writer writer = new FileWriter("text-as-bytes.txt");

        for (byte b : bytes) {
            String out = String.valueOf(b);
            if (b == 32) {
                out = " ";
            } else if (b == 10) {
                out = System.lineSeparator();
            }

            writer.write(out);
        }
writer.flush();

    }
}
