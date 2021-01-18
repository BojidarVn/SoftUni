package Wild_Farm;

public class Cat extends Feline {
    String breed;

    public Cat(String name, String type, Double wight, String livingRegion,String breed) {
        super(name, type, wight, livingRegion);
        this.breed=breed;
    }

    @Override
    public void eat(Food food) {
        this.incrementFood(food.getQuantity());
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder("Cat");
        sb.append(super.toString());

        sb.insert(sb.indexOf (",") + 1, " "+ this.breed + ",");

        return sb.toString();
    }
}
