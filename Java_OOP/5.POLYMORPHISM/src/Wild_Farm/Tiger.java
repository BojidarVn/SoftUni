package Wild_Farm;

public class Tiger extends Feline {
    public Tiger(String name, String type, Double wight, String livingRegion) {
        super(name, type, wight,  livingRegion);
    }

    @Override
    public void eat(Food food){
        if (!food.getType().equals("Meat")) {
            throw new IllegalStateException("Tigers are not eating that type of food!");
        }
        super.incrementFood(food.getQuantity());
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public String toString() {
        return "Tiger" + super.toString();
    }
}
