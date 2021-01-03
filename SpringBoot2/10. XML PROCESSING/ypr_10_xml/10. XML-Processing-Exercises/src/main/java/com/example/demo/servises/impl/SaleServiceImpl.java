package com.example.demo.servises.impl;

import com.example.demo.domaint.dtos.lastQueryExport.SaleExportDto;
import com.example.demo.domaint.dtos.lastQueryExport.SaleExportRootDto;
import com.example.demo.domaint.entities.Car;
import com.example.demo.domaint.entities.Customer;
import com.example.demo.domaint.entities.Part;
import com.example.demo.domaint.entities.Sale;
import com.example.demo.domaint.repositories.CarRepository;
import com.example.demo.domaint.repositories.CustomerRepository;
import com.example.demo.domaint.repositories.SaleRepository;
import com.example.demo.servises.SaleService;
import com.example.demo.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {

    private final static String SALE_DISCOUNT_PATH = "src/main/resources/xml/Exported/sales-discounts.xml";

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;


    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository
            , CustomerRepository customerRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;

        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSalesInDB() {

        Sale sale = new Sale();
        sale.setCar(getRandomCar());
        sale.setCustomer(getRandomCustomer());
        sale.setDiscount(5);

        Sale sale1 = new Sale();
        sale1.setCar(getRandomCar());
        sale1.setCustomer(getRandomCustomer());
        sale1.setDiscount(10);

        Sale sale2 = new Sale();
        sale2.setCar(getRandomCar());
        sale2.setCustomer(getRandomCustomer());
        sale2.setDiscount(30);

        this.saleRepository.saveAndFlush(sale);
        this.saleRepository.saveAndFlush(sale1);
        this.saleRepository.saveAndFlush(sale2);

    }

    @Override
    public void saleDiscount() throws JAXBException {

        SaleExportRootDto saleExportRootDto = new SaleExportRootDto();
        List<SaleExportDto> saleExportDtos = new ArrayList<>();

        for (Sale sale : this.saleRepository.findAll()) {
            SaleExportDto saleExportDto = this.modelMapper.map(sale, SaleExportDto.class);
            saleExportDto.setDiscount(saleExportDto.getDiscount() / 100);

            double totalPrice = sale.getCar().getParts()
                    .stream()
                    .mapToDouble(Part::getPrice)
                    .sum();

            // ako be6e BigDecimal
//            double totalPrice = sale.getCar().getParts()
//                    .stream()
//                    .mapToDouble(p-> Double.parseDouble(p.getPrice().toString()))
//                    .sum();


            saleExportDto.setPrice(totalPrice);
//          saleExportDto.setPrice(BigDecimal.valueOf(totalPrice));


            saleExportDtos.add(saleExportDto);


            double priceWithDiscount = totalPrice - totalPrice * sale.getDiscount() * 1.0 / 100;
            saleExportDto.setPriceWithDiscount(priceWithDiscount);
//            saleExportDto.setPriceWithDiscount(BigDecimal.valueOf(priceWithDiscount));

        }
        saleExportRootDto.setSales(saleExportDtos);

        this.xmlParser.exportXml(saleExportRootDto ,SaleExportRootDto.class, SALE_DISCOUNT_PATH );

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
