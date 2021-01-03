package softuni.cardealer.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.export.CarExportDto;
import softuni.cardealer.domain.dtos.export.CustomerSalesExportDto;
import softuni.cardealer.domain.dtos.export.SalesInfoExportDto;
import softuni.cardealer.domain.entities.Car;
import softuni.cardealer.domain.entities.Customer;
import softuni.cardealer.domain.entities.Part;
import softuni.cardealer.domain.entities.Sale;
import softuni.cardealer.domain.repositories.CarRepository;
import softuni.cardealer.domain.repositories.CustomerRepository;
import softuni.cardealer.domain.repositories.SaleRepository;
import softuni.cardealer.services.SaleService;

import java.math.BigDecimal;
import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedSalesInDB() {

        for (int i = 1; i <= 5; i++) {
            Sale sale = new Sale();
            Customer customer = getRandomCustomer();
            int discount = getRandomDiscount();
            Car car = getRandomCar();
            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscount(discount);

            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public String getCustomersWithSales() {
        Set<Customer> allCustomerTotalSales = this.customerRepository.getAllCustomerTotalSales();

        List<CustomerSalesExportDto> toExport = new ArrayList<>();
        for (Customer customer : allCustomerTotalSales) {
            double sum = 0;
            CustomerSalesExportDto customerSalesExportDto =
                    this.modelMapper.map(customer, CustomerSalesExportDto.class);
            customerSalesExportDto.setFullName(customer.getName());
            customerSalesExportDto.setBoughtCars(customer.getSales().size());
            for (Sale sale : customer.getSales()) {
                sum = sale.getCar().getParts().stream().mapToDouble(Part::getPrice).sum();
            }
            customerSalesExportDto.setSpentMoney(BigDecimal.valueOf(sum));

            toExport.add(customerSalesExportDto);
        }

        return this.gson.toJson(toExport);
    }

    @Override
    public String getAllSalesInfo() {
        Set<Sale> allBy = this.saleRepository.findAllBy();

        List<SalesInfoExportDto> toExport = new ArrayList<>();
        for (Sale sale : allBy) {
            SalesInfoExportDto salesInfoExportDto = this.modelMapper.map(sale, SalesInfoExportDto.class);
            CarExportDto carExportDto = new CarExportDto();
            carExportDto.setMake(sale.getCar().getMake());
            carExportDto.setModel(sale.getCar().getModel());
            carExportDto.setTravelledDistance(String.valueOf(sale.getCar().getTravelledDistance()));

            salesInfoExportDto.setCar(carExportDto);

            salesInfoExportDto.setCustomerName(sale.getCustomer().getName());
            salesInfoExportDto.setDiscount(BigDecimal.valueOf(sale.getDiscount()));

            double price = sale.getCar().getParts().stream().mapToDouble(Part::getPrice).sum();
            salesInfoExportDto.setPrice(BigDecimal.valueOf(price));

            double priceWithDiscount = price - (price * sale.getDiscount() / 100);
            salesInfoExportDto.setPriceWithDiscount(BigDecimal.valueOf(priceWithDiscount));

            toExport.add(salesInfoExportDto);
        }

        return this.gson.toJson(toExport);
    }

    private int getRandomDiscount() {
        Random random = new Random();
        int num = random.nextInt(50) + 1;
        return num;
    }

    private Car getRandomCar() {
        Random random = new Random();
        long index = random.nextInt((int) this.carRepository.count()) + 1;
        Car car = this.carRepository.findById(index).get();
        return car;
    }

    private Customer getRandomCustomer() {
        Random random = new Random();
        long index = random.nextInt((int) this.customerRepository.count()) + 1;
        Customer customer = this.customerRepository.findById(index).get();
        return customer;
    }
}
