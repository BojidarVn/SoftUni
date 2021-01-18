package Wild_Farm;

public abstract class Mammal extends Animal  {
    private String livingRegion;

    public Mammal(String name, String type, Double wight,String livingRegion) {
        super(name, type, wight);
        this.livingRegion=livingRegion;
    }
    @Override
    public void eat(Food food) {
        if (food.getType().equals("Meat")) {
            String type =getType().equals("Mouse")
                    ? "Mice" : "Zebras";

            throw new IllegalStateException(type+ " are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder(super.toString());

        sb.insert(sb.lastIndexOf(",") + 1, " "+ this.livingRegion + ",");
        return sb.toString();
    }
}
