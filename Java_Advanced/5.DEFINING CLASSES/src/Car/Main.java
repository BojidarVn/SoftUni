package Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);



        int n = Integer.parseInt(Scanner.nextLine());

        List<Car> cars=new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = Scanner.nextLine().split("\\s+");
            String brand = tokens[0];

            Car car;

            if (tokens.length == 3) {
                 car=new Car(brand,tokens[1],Integer.parseInt(tokens[2]));
            } else if (tokens.length ==2) {
                car=new Car(brand,tokens[1]);
            } else {
                car=new Car(brand);
            }
          //  String model = tokens[1];
          //  int horsePower = Integer.parseInt(tokens[2]);


          //  Car car = new Car(brand, model, horsePower);
          //  Car car2=new Car();

 //           car.setBrand(brand);
 //           car.setModel(model);
 //           car.setHorsePower(horsePower);

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }

}
