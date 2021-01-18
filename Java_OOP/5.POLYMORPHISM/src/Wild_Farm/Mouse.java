package Wild_Farm;

public class Mouse extends Mammal {
    public Mouse(String name, String type, Double wight,  String livingRegion) {
        super(name, type, wight, livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public String toString() {
        return "Mouse" + super.toString();
    }
}
