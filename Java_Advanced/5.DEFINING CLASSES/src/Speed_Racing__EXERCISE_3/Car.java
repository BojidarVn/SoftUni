package Speed_Racing__EXERCISE_3;

public class Car {
    private String model;
    private Double fuel;
    private Double consumption;
    private int distance;

    public Car (String mode,Double fuel,Double consumption) {
     this.model=mode;
     this.fuel=fuel;
     this.consumption=consumption;
     this.distance=0;
    }


    public boolean drive(int distance) {
        double fuelNeeded=distance*consumption;
      if(fuelNeeded<=this.fuel) {
          this.distance+=distance;
          this.fuel-=fuelNeeded;
          return true;
      }

      return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }

}
