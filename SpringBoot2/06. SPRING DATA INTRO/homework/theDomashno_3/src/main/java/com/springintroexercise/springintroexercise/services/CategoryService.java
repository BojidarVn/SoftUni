package com.springintroexercise.springintroexercise.services;

import com.springintroexercise.springintroexercise.entities.Category;

import java.io.IOException;

public interface CategoryService {

    void seedCategory() throws IOException;

    Category getCategoryById(Integer id);
}
