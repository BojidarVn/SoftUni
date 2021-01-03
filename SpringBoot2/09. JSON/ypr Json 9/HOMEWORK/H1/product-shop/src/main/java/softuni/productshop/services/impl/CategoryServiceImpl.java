package softuni.productshop.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.productshop.domain.dtos.exportDtos.CategoryExportDto;
import softuni.productshop.domain.dtos.importedDtos.CategoriesImportDto;
import softuni.productshop.domain.entities.Category;
import softuni.productshop.domain.entities.Product;
import softuni.productshop.repositories.CategoryRepository;
import softuni.productshop.services.CategoryService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ModelMapper modelMapper, Gson gson, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategoriesInDB() throws IOException {
        String content =
                String.join("", Files.readAllLines(Path.of("src/main/resources/jsons/categories.json")));

        CategoriesImportDto[] categoriesImportDto = this.gson.fromJson(content, CategoriesImportDto[].class);
        for (CategoriesImportDto importDto : categoriesImportDto) {
            Category category = this.modelMapper.map(importDto, Category.class);

            this.categoryRepository.saveAndFlush(category);
        }
    }

    @Override
    public String getCategoriesByProducts() {
        Set<Category> allCategoriesByProducts = this.categoryRepository.getAllCategoriesByProducts();

        List<CategoryExportDto> toExport = new ArrayList<>();
        for (Category allCategoriesByProduct : allCategoriesByProducts) {
            CategoryExportDto category = this.modelMapper.map(allCategoriesByProduct, CategoryExportDto.class);

            category.setCategory(allCategoriesByProduct.getName());
            category.setProductsCount(allCategoriesByProduct.getProducts().size());

            category.setAveragePrice(allCategoriesByProduct.getProducts().stream().mapToDouble(Product::getPrice).sum() /
                    allCategoriesByProduct.getProducts().size());
            category.setTotalRevenue(allCategoriesByProduct.getProducts().stream().mapToDouble(Product::getPrice).sum());

            toExport.add(category);
        }

        return this.gson.toJson(toExport);
    }
}
