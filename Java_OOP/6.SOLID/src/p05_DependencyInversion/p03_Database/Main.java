package p05_DependencyInversion.p03_Database;

public class Main {
    public static void main(String[] args) {
       Courses courses=new Courses(new Data());
       Courses courses2=new Courses(new CoursesDatabase());




    }
}
