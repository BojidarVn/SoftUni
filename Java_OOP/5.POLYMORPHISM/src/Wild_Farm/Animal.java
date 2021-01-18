package Wild_Farm;

import java.text.DecimalFormat;

public abstract class Animal implements Eat,ProduceSound {
    private String name;
    private String type;
    private Double wight;
    private Integer foodEaten;

    public Animal(String name, String type, Double wight) {
        this.name = name;
        this.type = type;
        this.wight = wight;
        this.foodEaten = 0;
    }

    @Override
    public void eat (Food food) {
        this.foodEaten+=food.getQuantity();
    }

    protected void incrementFood (int quantity){
        this.foodEaten+=quantity;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString(){
        return String.format("[%s, %s, %d]",
                this.name,
                new DecimalFormat("##.##").format(this.wight),
                this.foodEaten);

    }
}
