package softuni.productshop.services;

import java.io.IOException;

public interface CategoryService {

    void seedCategoriesInDB() throws IOException;

    String getCategoriesByProducts();
}
