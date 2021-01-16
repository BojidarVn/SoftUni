package Animal;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGander(gender);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalStateException("Invalid input!");
        }
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Invalid input!");
        }
        this.age = age;
    }

    public void setGander(String gender) {
        validateParam(gender);
        this.gender = gender;
    }

    private void validateParam(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Invalid input!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(),
                this.name, this.age,
                this.gender,this.produceSound() );
    }

    public String produceSound() {
        return "";
    }
}
