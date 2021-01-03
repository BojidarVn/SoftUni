package com.softuni.exercise_6.services;

import com.softuni.exercise_6.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

   Category getCategoryById(Long id);
}
