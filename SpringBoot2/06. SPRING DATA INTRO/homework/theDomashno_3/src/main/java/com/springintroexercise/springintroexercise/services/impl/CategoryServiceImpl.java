package com.springintroexercise.springintroexercise.services.impl;

import com.springintroexercise.springintroexercise.entities.Category;
import com.springintroexercise.springintroexercise.repositories.CategoryRep;
import com.springintroexercise.springintroexercise.services.CategoryService;
import com.springintroexercise.springintroexercise.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final static String CATEGORY_PATH = "src/main/resources/files/categories.txt";

    private final CategoryRep categoryRep;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRep categoryRep, FileUtil fileUtil) {
        this.categoryRep = categoryRep;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategory() throws IOException {
        if (this.categoryRep.count() != 0) {
            return;
        }

        String[] categories = this.fileUtil.fileContext(CATEGORY_PATH);

        for (String s : categories) {
            Category category = new Category();
            category.setName(s);
            this.categoryRep.saveAndFlush(category);
        }
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryRep.getOne(id);
    }
}
