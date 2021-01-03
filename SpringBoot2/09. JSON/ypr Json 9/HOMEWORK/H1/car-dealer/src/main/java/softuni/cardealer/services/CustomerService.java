package softuni.cardealer.services;

import java.io.IOException;

public interface CustomerService {

    void seedCustomerInDB() throws IOException;

    String orderedCustomers();

}
