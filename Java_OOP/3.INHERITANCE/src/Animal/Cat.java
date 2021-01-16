package Animal;

public class Cat extends Animal {
    public Cat(String name, int age, String gander) {
        super(name, age, gander);
    }

    @Override
    public String produceSound() {
        return "Meow meow";
    }
}
