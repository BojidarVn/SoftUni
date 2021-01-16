package people;

import org.w3c.dom.ls.LSOutput;

public class Student extends Person {
    private String school;

    public Student(String school) {
        super("sdaad","dads");
        this.school=school;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void sleep() {
        System.out.println("Student is sleeping at school");
    }
}
