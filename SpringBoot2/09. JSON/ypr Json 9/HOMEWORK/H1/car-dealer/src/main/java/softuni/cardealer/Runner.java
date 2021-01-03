package softuni.cardealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.cardealer.services.*;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public Runner(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedDatabase();


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CHANGE USERNAME AND PASSWORD IN APPLICATION.PROPERTIES");
            System.out.println("Select exercise: 1-6 or 0 for the program to end!");
            int num = Integer.parseInt(scanner.nextLine());

            switch (num) {
                case 1:
                System.out.println(this.customerService.orderedCustomers());
                break;
                case 2:
                System.out.println(this.carService.getToyotaCars("Toyota"));
                break;
                case 3:
                System.out.println(this.supplierService.getLocalSuppliers());
                break;
                case 4:
                System.out.println(this.carService.getCarsWithParts());
                break;
                case 5:
                System.out.println(this.saleService.getCustomersWithSales());
                break;
                case 6:
                System.out.println(this.saleService.getAllSalesInfo());
                break;
                case 0:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid exercise!");
                    break;
            }
        }
    }

    private void seedDatabase() throws Exception {
        this.supplierService.seedSupplierInDB();
        this.partService.seedPartsInDB();
        this.carService.seedCarsInDB();
        this.customerService.seedCustomerInDB();
        this.saleService.seedSalesInDB();
    }
}
