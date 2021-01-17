package Food_Shortage_EXERCISE_4;

public abstract class AbstractCitizen implements Person, Buyer {
    private String name;
    private int age;
    private int food;

    protected AbstractCitizen(String name, int age) {
        this.name = name;
        this.age = age;
        this.food = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    protected void addFood(int addition) {
        this.food+=addition;
    }



    public abstract void buyFood();
}
