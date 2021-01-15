package Pizza_Calories;

public class Topping {
    private ToppingType toppingType;
    private double wight;

    public Topping(String toppingType, double wight) {
        this.setToppingType(toppingType);
        this.setWight(wight);
    }

    public double getWight() {
        return this.wight;
    }

    public ToppingType getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        try {
            this.toppingType = ToppingType.valueOf(toppingType.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }

    private void setWight(double wight) {
        if (wight < 1 || wight > 50) {
            throw new IllegalArgumentException(String
                    .format("%s weight should be in the range [1..50].", this.getToppingType().name()));
        }

        this.wight = wight;
    }

    public double calculateCalories() {

        return 2 * this.getWight() * toppingType.getModifier();
    }
}
