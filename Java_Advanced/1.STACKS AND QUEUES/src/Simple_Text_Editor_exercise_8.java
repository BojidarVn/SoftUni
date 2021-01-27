import java.util.ArrayDeque;
import java.util.Scanner;

public class Simple_Text_Editor_exercise_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //Можем да използваме вградените методи в append/delete
        StringBuilder text = new StringBuilder();

        //Стак, където пазим миналите команди ! Трябва ни за операция 4.
        ArrayDeque<String> prevCommands = new ArrayDeque<>();

        //Стак, където пазим изтритите вече думи.
        ArrayDeque<String> deletedCharacters = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            //Пълним стака с изминалите команди.
            String rawCommand = scanner.nextLine();
            String[] tokens = rawCommand.split("\\s+");

            switch (tokens[0]) {
                case "1":
                    prevCommands.push(rawCommand);
                    text.append(tokens[1]);
                    break;
                case "2":
                    prevCommands.push(rawCommand);
                    int toDelete = Integer.parseInt(tokens[1]);

                    //пълним вече изтритите букви
                    deletedCharacters.push(text.substring(text.length() - toDelete));

                    //трием изтритие букви
                    text.delete(text.length() - toDelete, text.length());
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    String prevCommand = prevCommands.pop();
                    String[] tkns = prevCommand.split("\\s+");

                    //При команда 1, връщаме промяната -> трием последно добавените букви
                    //При команда 2, добавяме последно премахнатите букви като ги взимаме от стека.
                    if (tkns[0].equals("1")) {
                        int countToDelete = tkns[1].length();
                        text.delete(text.length() - countToDelete, text.length());
                    } else if (tkns[0].equals("2")) {
                        String toAdd = deletedCharacters.pop();
                        text.append(toAdd);
                    }
                    break;
            }
        }
    }
}