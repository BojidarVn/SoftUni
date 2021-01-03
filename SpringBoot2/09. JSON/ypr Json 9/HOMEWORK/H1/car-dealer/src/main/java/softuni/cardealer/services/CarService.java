package softuni.cardealer.services;

import java.io.IOException;

public interface CarService {

    void seedCarsInDB() throws Exception;

    String getToyotaCars(String maker);

    String getCarsWithParts();
}
