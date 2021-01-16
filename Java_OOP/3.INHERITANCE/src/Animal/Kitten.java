package Animal;

public class Kitten extends Cat {
    public static final String GENDER = Gender.FEMALE.toString();

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
