package softuni.cardelar.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardelar.domain.entities.Car;
import softuni.cardelar.domain.entities.Customer;
import softuni.cardelar.domain.entities.Sale;
import softuni.cardelar.domain.repositories.CarRepository;
import softuni.cardelar.domain.repositories.CustomerRepository;
import softuni.cardelar.domain.repositories.SeleRepository;
import softuni.cardelar.services.SeleService;

import java.util.Random;

@Service
public class SaleServiceImpl implements SeleService {



    private final SeleRepository seleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    public SaleServiceImpl(SeleRepository seleRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.seleRepository = seleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }



    @Override
    public void seedSales() {

        Sale sale=new Sale();
        sale.setCar(getRandomCar());
        sale.setCustomer(getRandomCustomer());
        sale.setDiscount(5);

        Sale sale1=new Sale();
        sale1.setCar(getRandomCar());
        sale1.setCustomer(getRandomCustomer());
        sale1.setDiscount(10);

        Sale sale2=new Sale();
        sale2.setCar(getRandomCar());
        sale2.setCustomer(getRandomCustomer());
        sale2.setDiscount(30);

        this.seleRepository.saveAndFlush(sale);
        this.seleRepository.saveAndFlush(sale1);
        this.seleRepository.saveAndFlush(sale2);


    }

    private Customer getRandomCustomer() {
        Random random=new Random();
        long id = random.nextInt((int) this.customerRepository.count()) +1;
        return this.customerRepository.findById(id).get();


    }

    private Car getRandomCar() {
        Random random=new Random();
        long id = (long) random.nextInt( (int) this.carRepository.count()) + 1;

        return this.carRepository.findById(id).get();
    }
}




































