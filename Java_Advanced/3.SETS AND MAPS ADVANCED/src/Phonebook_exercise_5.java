import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Phonebook_exercise_5 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);


        //   String input=Scanner.nextLine();

        Map<String,String> phoneBook=new HashMap<>();

        String line="";

        while (!(line=Scanner.nextLine()).equals("search")) {
            String[] tokens=line.split("-");

            phoneBook.put(tokens[0],tokens[1]);
        }

        while (!(line=Scanner.nextLine()).equals("stop")) {
            if(phoneBook.containsKey(line)) {
                System.out.printf("%s -> %s%n", line,phoneBook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.%n",line);
            }
        }
    }
}
