package Wild_Farm;

public abstract class Food {
    private int quantity;

    protected Food (int quantity) {
        this.quantity=quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public abstract String getType();

}
