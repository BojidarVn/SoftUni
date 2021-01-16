package Animal;

public class Tomcat extends Cat {
    public static final String GENDER = Gender.MALE.toString();
    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
