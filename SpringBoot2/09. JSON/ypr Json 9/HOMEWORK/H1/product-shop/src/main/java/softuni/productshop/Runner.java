package softuni.productshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.productshop.services.CategoryService;
import softuni.productshop.services.ProductService;
import softuni.productshop.services.UserService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public Runner(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedDatabase();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CHANGE USERNAME AND PASSWORD IN APPLICATION.PROPERTIES");
            System.out.println("Select exercise: 1-3 or 0 for the program to end!");
            int num = Integer.parseInt(scanner.nextLine());

            switch (num) {
                case 1:
                    System.out.println(this.productService.getProductsInRange(500.00, 1000.00));
                    break;
                case 2:
                    System.out.println(this.productService.getAllUsersThatSoldAtLeastOneProduct());
                    break;
                case 3:
                    System.out.println(this.categoryService.getCategoriesByProducts());
                    break;
                case 0:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid!");


            }
        }
    }

    private void seedDatabase () throws IOException {
        this.userService.seedUsersInDB();
        this.categoryService.seedCategoriesInDB();
        this.productService.seedProductsInDB();
    }
}
