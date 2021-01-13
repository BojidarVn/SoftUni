package StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String studentInformation() {
        return String.format("%s is %s years old. %s",
                this.getName(),
                this.getAge(),
                this.createCommentaryBasedOnGrade());

    }

    private String createCommentaryBasedOnGrade() {
        if (this.getGrade() >= 5.00) {
            return "Excellent student.";
        }
        if (this.getGrade() < 5.00 && this.getGrade() >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";


    }

    public double getGrade() {
        return this.grade;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }


}
