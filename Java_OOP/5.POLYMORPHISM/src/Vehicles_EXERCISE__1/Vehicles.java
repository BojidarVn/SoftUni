package Vehicles_EXERCISE__1;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuel;
    private double fuelConsumption;
private DecimalFormat formatter;


    protected Vehicles(double fuel, double fuelConsumption) {
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.formatter=new DecimalFormat("##.##");
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        if (fuelNeeded > this.fuel) {
            return " needs refueling";
        }
        this.fuel -= fuelNeeded;
        return " travelled " +formatter.format(distance)  +  " km";

    }

    public void refuel(double quantity) {
        this.fuel += quantity;
    }

    @Override
    public String toString() {
        return String.format(": %.2f", this.fuel);
    }
}
