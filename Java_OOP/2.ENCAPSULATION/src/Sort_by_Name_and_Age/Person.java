package Sort_by_Name_and_Age;


public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0);
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.initialSalary(salary);
    }

    public void initialSalary(double salary) {
        if (salary<460) {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary=salary;
    }

    public void setAge(int age) {
        if (age<= 0) {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age=age;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<3) {
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
        this.lastName=lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()<3) {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName=firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.initialSalary(salary);
    }

   public void increaseSalary(double amount) {
       if (this.getAge() < 30) {
          this.setSalary(this.getSalary() + getSalary()*amount/200 );
       }    else {

           this.setSalary(this.getSalary()+ this.getSalary()*amount/100);
       }
   }

    @Override
    public String toString() {

        return String.format("%s %s gets %.1f leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
