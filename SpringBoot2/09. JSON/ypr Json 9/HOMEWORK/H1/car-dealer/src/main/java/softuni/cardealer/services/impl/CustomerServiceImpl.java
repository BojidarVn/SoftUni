package softuni.cardealer.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.export.CustomerExportDto;
import softuni.cardealer.domain.dtos.export.CustomerSalesExportDto;
import softuni.cardealer.domain.dtos.importDtos.CustomerSeedDto;
import softuni.cardealer.domain.entities.Customer;
import softuni.cardealer.domain.repositories.CustomerRepository;
import softuni.cardealer.services.CustomerService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final ModelMapper modelMapper;
    private final static String CUSTOMER_PATH = "src/main/resources/json/customers.json";
    private final Gson gson;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ModelMapper modelMapper, Gson gson, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedCustomerInDB() throws IOException {
        String content = String.join("", Files.readAllLines(Path.of(CUSTOMER_PATH)));
        CustomerSeedDto[] customerSeedDtos = this.gson.fromJson(content, CustomerSeedDto[].class);

        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);
            this.customerRepository.saveAndFlush(customer);
        }
    }

    @Override
    public String orderedCustomers() {
        Set<Customer> allByOrderByYoungDriverAscBirthDateAsc =
                this.customerRepository.getAllByOrderByBirthDateAscYoungDriverAsc();

        List<CustomerExportDto> toExport = new ArrayList<>();
        for (Customer customer : allByOrderByYoungDriverAscBirthDateAsc) {
            CustomerExportDto customerExportDto =
                    this.modelMapper.map(customer, CustomerExportDto.class);
            toExport.add(customerExportDto);
        }
        return this.gson.toJson(toExport);
    }


}
