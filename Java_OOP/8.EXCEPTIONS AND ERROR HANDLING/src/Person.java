public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName,"first Name");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName,"last Name");
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age <0 || age>120) {
            throw new IllegalArgumentException("Age should be in range [0 ... 120]");
        }
        this.age = age;
    }

    private void validateName(String name, String paramName) {
        if (name == null || name.trim().isEmpty()) {
            throw  new IllegalArgumentException("The "+ paramName+" cannot be null or empty");
        }
    }
}
