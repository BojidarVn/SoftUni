package Vehicles_Extension_EXERCISE_2;

public class Bus extends Vehicles {
    public Bus(double fuel, double fuelConsumption, int capacity) {
        super(fuel, fuelConsumption, capacity);
    }

    @Override
    public String drive(double distance){
        return "Bus" + super.drive(distance);
    }

    public String driveWithPassengers(double distance) {
        super.increaseConsumption(1.4);
        return this.drive(distance);
    }

    @Override
    public String toString() {
        return "Bus" + super.toString();
    }
}
