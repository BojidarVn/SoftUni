package Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String line = Scanner.nextLine();

        List<Animal> animals=new ArrayList<>();

        while (!line.equals("Beast!")) {
            String type=line;
            String[] tokens=Scanner.nextLine().split("\\s+");

            try {

                Animal animal= createAnimal(type,tokens);
                animals.add(animal);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

            line=Scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());

        }

    }

    private static Animal createAnimal(String type, String[] tokens) {


        String name =tokens[0];
        int age=Integer.parseInt(tokens[1]);
        String gender="";
        if (!type.equals("Kitten") && !type.equals("Tomcat")) {
             gender=tokens[2];
        }

        Animal animal;
        switch (type) {
            case "Cat":
                animal= new Cat (name,age,gender);
                break;
            case "Dog":
                animal= new Dog (name,age,gender);
                break;
            case "Frog":
                animal= new Frog (name,age,gender);
                break;
            case "Kitten":
                animal= new Kitten (name,age);
                break;
            case "Tomcat":
                animal= new Tomcat (name,age);
                break;
            default:
                throw new IllegalStateException("invalid animal type!");

        }
        return animal;
    }
}
