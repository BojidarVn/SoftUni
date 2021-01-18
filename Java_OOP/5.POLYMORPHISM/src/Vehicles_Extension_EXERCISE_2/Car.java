package Vehicles_Extension_EXERCISE_2;

public class Car extends Vehicles {
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;


    public Car(double fuel, double fuelConsumption,int capacity) {
        super(fuel, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, capacity);
    }

    @Override
    public String drive(double distance) {
        return "Car" + super.drive(distance);
    }

    @Override
    public String toString() {
        return "Car" + super.toString();
    }

}
