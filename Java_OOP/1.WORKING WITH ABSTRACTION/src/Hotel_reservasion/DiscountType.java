package Hotel_reservasion;

public enum DiscountType {

    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0.0);

    private double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double discountFor(double amount) {
        double discount=amount*this.discount;
        return amount-discount;
    }


    public static void main(String[] args) {
        System.out.println(DiscountType.VIP.discountFor(15));
        System.out.println(DiscountType.SECOND_VISIT.discountFor(15));
        System.out.println(DiscountType.NONE.discountFor(15));
    }
}
