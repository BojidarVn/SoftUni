package softuni.productshop.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.productshop.domain.dtos.exportDtos.*;
import softuni.productshop.domain.dtos.importedDtos.ProductImportDto;
import softuni.productshop.domain.entities.Category;
import softuni.productshop.domain.entities.Product;
import softuni.productshop.domain.entities.User;
import softuni.productshop.repositories.CategoryRepository;
import softuni.productshop.repositories.ProductRepository;
import softuni.productshop.repositories.UserRepository;
import softuni.productshop.services.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final static String PRODUCT_PATH = "src/main/resources/jsons/products.json";
    private static final Random random = new Random();
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, Gson gson, ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedProductsInDB() throws IOException {
        String content = String.join("", Files.readAllLines(Path.of(PRODUCT_PATH)));
        ProductImportDto[] productImportDtos = this.gson.fromJson(content, ProductImportDto[].class);
        try{
             productImportDtos = this.gson.fromJson(content, ProductImportDto[].class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        for (ProductImportDto importDto : productImportDtos) {
            Product product = this.modelMapper.map(importDto, Product.class);
            product.setSellerId(getRandomSeller());
            product.setBuyerId(getRandomBuyer());
            product.setCategories(getRandomCategories());

            this.productRepository.saveAndFlush(product);
        }
    }


    @Override
    public String getProductsInRange(double lowerBound, double upperBound) {
        Set<Product> allByPriceBetween =
                this.productRepository.findAllByPriceBetweenOrderByPriceAsc(lowerBound, upperBound);

        List<ProductExportDto> toExport = new ArrayList<>();
        for (Product product : allByPriceBetween) {
            ProductExportDto productExportDto = this.modelMapper.map(product, ProductExportDto.class);

            String fullName = String.format("%s %s", product.getSellerId().getFirstName(), product.getSellerId().getLastName());
            productExportDto.setSeller(fullName);
            toExport.add(productExportDto);
        }

        return this.gson.toJson(toExport);
    }

    @Override
    public String getAllUsersThatSoldAtLeastOneProduct() {
        Set<Product> allUsersWithOneSoldProduct = this.productRepository.findAllBySellerIdIsNotNull();

        List<SellerAndBuyerExportDto> toExport = new ArrayList<>();
        for (Product product : allUsersWithOneSoldProduct) {
            SellerAndBuyerExportDto sellerAndBuyerExportDto = this.modelMapper.map(product, SellerAndBuyerExportDto.class);
            sellerAndBuyerExportDto.setFirstName(product.getSellerId().getFirstName());
            sellerAndBuyerExportDto.setLastName(product.getSellerId().getLastName());

            List<ProductExportDtoEx2> productExportDtoEx2s = new ArrayList<>();

            ProductExportDtoEx2 productExportDtoEx2 = new ProductExportDtoEx2();

            productExportDtoEx2.setName(product.getName());
            productExportDtoEx2.setPrice(BigDecimal.valueOf(product.getPrice()));
            productExportDtoEx2.setBuyerFirstName(product.getBuyerId().getFirstName());
            productExportDtoEx2.setBuyerLastName(product.getBuyerId().getLastName());

            productExportDtoEx2s.add(productExportDtoEx2);

            sellerAndBuyerExportDto.setSoldProducts(productExportDtoEx2s);

            toExport.add(sellerAndBuyerExportDto);
        }

        return this.gson.toJson(toExport);
    }

    @Override
    public String getAllUsersAndProducts() {
        Set<Product> allUsersAndProducts = this.productRepository.getAllUsersAndProducts();

        List<UsersAndProductsExportDto> toExport = new ArrayList<>();
        for (Product allUsersAndProduct : allUsersAndProducts) {
            UsersAndProductsExportDto usersAndProductsExportDto =
                    this.modelMapper.map(allUsersAndProduct, UsersAndProductsExportDto.class);
            usersAndProductsExportDto.setUsersCount(allUsersAndProduct.getSellerId().getUsers().size());

            UserExportDto userExportDto = new UserExportDto();
            ProductExportDtoEx4 productExportDtoEx4 = new ProductExportDtoEx4();

            productExportDtoEx4.setCount(allUsersAndProduct.getSellerId().getUsers().size());

            userExportDto.setFirstName(allUsersAndProduct.getSellerId().getFirstName());
            userExportDto.setLastName(allUsersAndProduct.getSellerId().getLastName());
            userExportDto.setAge(allUsersAndProduct.getSellerId().getAge());


            usersAndProductsExportDto.setUsers(userExportDto);
        }
        return null;
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < 1; i++) {
            long index = random.nextInt((int) this.categoryRepository.count()) + 1;
            Category category = this.categoryRepository.findById(index).get();

            categories.add(category);
        }

        return categories;
    }

    private User getRandomBuyer() {

        long index = random.nextInt((int) this.userRepository.count()) + 1;
        Optional<User> buyer = this.userRepository.findById(index);

        if (buyer.isPresent()){
            return buyer.get();
        }
        else {
            return null;
        }

    }

    private User getRandomSeller() {

        long index = random.nextInt((int) this.userRepository.count()) + 1;
        Optional<User> seller = this.userRepository.findById(index);

        if (seller.isPresent()){
            return seller.get();
        }
        else {
            return null;
        }

    }
}
