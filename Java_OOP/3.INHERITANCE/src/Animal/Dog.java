package Animal;

public class Dog extends Animal {
    public Dog(String name, int age, String gander) {
        super(name, age, gander);
    }

    @Override
    public String produceSound() {
        return "Woof!";
    }
}
