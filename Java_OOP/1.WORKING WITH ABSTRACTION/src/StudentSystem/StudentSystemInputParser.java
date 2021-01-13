package StudentSystem;

public class StudentSystemInputParser {





    public static Student createStudent(String[] args) {
        String name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        return new Student(name, age, grade);
    }
}
