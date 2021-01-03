package com.softuni.exercise_6.services.impl;

import com.softuni.exercise_6.entities.Category;
import com.softuni.exercise_6.repositories.CategoryRepository;
import com.softuni.exercise_6.services.CategoryService;
import com.softuni.exercise_6.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

import static com.softuni.exercise_6.constants.GlobalConstants.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtils fileUtils;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtils fileUtils) {
        this.categoryRepository = categoryRepository;
        this.fileUtils = fileUtils;
    }

    @Override
    public void seedCategories() throws IOException {

        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtils.readFileContent(CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    Category category = new Category(r);
                    this.categoryRepository.saveAndFlush(category);
                });

    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getOne(id);
    }

}
