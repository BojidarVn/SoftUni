import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Sort_Lines_LAB_6 {
    public static void main(String[] args) throws IOException {

        String fileName="input.txt";

        List<String> allLines = Files.readAllLines(Paths.get(fileName))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write (Paths.get("sorted-lines.txt"),allLines);

    }
}
