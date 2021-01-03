package softuni.cardelar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.cardelar.services.*;

@Component
public class Runner implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SeleService saleService;

    @Autowired
    public Runner(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SeleService seleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = seleService;
    }


    @Override
    public void run(String... args) throws Exception {
//        this.supplierService.seedSupplier();
//        this.partService.seedPart();
//        this.carService.seedCars();
//        this.customerService.seedCustomers();
//        this.saleService.seedSales();
//        this.customerService.oderCustomer();

        System.out.println(this.carService.findByToyota());

    }
}
