package softuni.cardelar.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardelar.domain.dtos.importDtos.CustomerSeedDto;
import softuni.cardelar.domain.entities.Customer;
import softuni.cardelar.domain.repositories.CustomerRepository;
import softuni.cardelar.services.CustomerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final static String CUSTOMER_PATH="src/main/resources/json/customers.json";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCustomers() throws IOException {

        // read
String content=String.join("", Files.readAllLines(Path.of(CUSTOMER_PATH)));

        //DTO -> json
        CustomerSeedDto[] customerSeedDtos=this.gson.fromJson(content,CustomerSeedDto[].class);

        //Save
        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {

            Customer customer=  this.modelMapper.map(customerSeedDto,Customer.class);

            this.customerRepository.saveAndFlush(customer);
        }

    }

    @Override
    public String oderCustomer() {

        Set<Customer> allByOrderByBirthdayAscYoungDriverAsc = this.customerRepository
                .getAllByOrderByBirthDateAscYoungDriverAsc();

        for (Customer customer : allByOrderByBirthdayAscYoungDriverAsc) {
            this.modelMapper.map(customer, CustomerSeedDto.class);
        }

       this.gson.toJson(allByOrderByBirthdayAscYoungDriverAsc);

        return null;
    }


}
