import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Homework homework = new Homework();
        homework.loadDatabaseDriver();
        homework.setConnectionToDatabase("root", "root");
        //homework.getVillainsNamesExercise2();
        //homework.getMinionNamesExercise3();
        //homework.addMinionExercise4();
        //homework.changeTownNamesCasingExercise5();
        //homework.removeVillainExercise6();
        //homework.printAllMinionNamesExercise7();
        //homework.increaseMinionsAgeExercise8();
        //homework.increaseAgeStoredProcedureExercise9();
    }
}