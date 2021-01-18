package Vehicles_EXERCISE__1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] input = Scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]));

        input = Scanner.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]));

        int N = Integer.parseInt(Scanner.nextLine());

        while (N-- > 0) {
            String[] tokens = Scanner.nextLine().split("\\s+");

            if (tokens[0].equals("Drive")) {
                System.out.println(driveCorrectVehicles(tokens[1], car, truck, Double.parseDouble(tokens[2])));
            } else {
                refuelCorrectVehicles(tokens[1], car, truck, Double.parseDouble(tokens[2]));
            }

        }

        System.out.println(car.toString());
        System.out.println(truck.toString());

    }

    private static void refuelCorrectVehicles(String type, Car car, Truck truck, double quantity) {
        if (type.equals("Car")) {
            car.refuel(quantity);
        } else {
            truck.refuel(quantity);
        }
    }

    private static String driveCorrectVehicles(String type, Car car, Truck truck, double distance) {

        if (type.equals("Car")) {
            return car.drive(distance);
        }
         return  truck.drive(distance);

    }
}
