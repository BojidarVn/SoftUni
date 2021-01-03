package springdataintroexercise.demo.services;


import springdataintroexercise.demo.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(Long id);
}
