package Wild_Farm;

public class Zebra extends Mammal {
    public Zebra(String name, String type, Double wight,  String livingRegion) {
        super(name, type, wight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public String toString() {
        return "Zebra" + super.toString();
    }
}

