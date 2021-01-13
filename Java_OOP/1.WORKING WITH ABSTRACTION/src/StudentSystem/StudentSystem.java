package StudentSystem;

public class StudentSystem {
    private StudentRepository repo;
    // private Map<String, Student> repo;

    public StudentSystem(StudentRepository repo) {
        this.repo = repo;
    }

    public void parseCommand(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");


    }

    public String studentInformationFor(String name) {

        if (repo.containsStudentWith(name)) {
            Student student = repo.fetchBy(name);
            return student.studentInformation();
        }
        return null;
    }

    public void persisUniqueStudent(Student student) {


        if (!repo.containsStudentWith(student.getName())) {

            repo.save(student);
        }
    }

    // Create <studentName> <studentAge> <studentGrade
    private Student createStudent(String[] args) {
        String name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        return new Student(name, age, grade);

    }
}
