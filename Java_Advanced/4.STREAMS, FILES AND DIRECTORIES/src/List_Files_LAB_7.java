import java.io.File;

public class List_Files_LAB_7 {
    public static void main(String[] args) {

        File file = new File("Files-and-Streams");

        File[] files = file.listFiles();

        for (File f : files) {
            if (!f.isDirectory())
            System.out.println(f.getName() + ": " + "[" +f.length() +"]");
        }


    }
}
