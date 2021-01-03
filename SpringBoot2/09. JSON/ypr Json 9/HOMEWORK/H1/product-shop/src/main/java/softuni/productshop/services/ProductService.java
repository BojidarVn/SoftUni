package softuni.productshop.services;

import java.io.IOException;
import java.math.BigDecimal;

public interface ProductService {

    void seedProductsInDB() throws IOException;

    String getProductsInRange(double lowerBound, double upperBound);

    String getAllUsersThatSoldAtLeastOneProduct();

    String getAllUsersAndProducts();
}
