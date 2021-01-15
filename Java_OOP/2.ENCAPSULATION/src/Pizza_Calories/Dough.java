package Pizza_Calories;

public class Dough {
    private FlourType flourType;
    private BakingTechnique bakingTechnique;
    private double wight;

    public Dough(String flourType, String bakingTechnique, double wight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWight(wight);
    }

    public double getWight() {
        return this.wight;
    }

    private void setWight(double wight) {
        if (wight < 1 || wight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.wight = wight;
    }

    public BakingTechnique getBakingTechnique() {
        return this.bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            this.bakingTechnique = BakingTechnique.valueOf(bakingTechnique.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    public FlourType getFlourType() {
        return this.flourType;
    }

    private void setFlourType(String flourType) {
        try {
            this.flourType = FlourType.valueOf(flourType.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        return 2 * this.getWight() * this.getBakingTechnique().getModifier() * this.flourType.getModifier();
    }
}
