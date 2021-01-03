package softuni.cardealer.services;

import java.io.IOException;

public interface SupplierService {

    void seedSupplierInDB() throws IOException;

    String getLocalSuppliers();
}
