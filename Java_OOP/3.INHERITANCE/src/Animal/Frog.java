package Animal;

public class Frog extends Animal {
    public Frog(String name, int age, String gander) {
        super(name, age, gander);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
