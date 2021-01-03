package com.example.demo.servises.impl;

import com.example.demo.domaint.dtos.export.CustomerOrderedExportDto;
import com.example.demo.domaint.dtos.export.CustomerOrderedRootExportDto;
import com.example.demo.domaint.dtos.importDtos.CustomerImportDto;
import com.example.demo.domaint.dtos.importDtos.CustomerImportRootDto;
import com.example.demo.domaint.entities.Customer;
import com.example.demo.domaint.repositories.CustomerRepository;
import com.example.demo.servises.CustomerService;
import com.example.demo.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final static String CUSTOMER_PATH = "src/main/resources/xml/customers.xml";
    private final static String CUSTOMERS_ORDERED_PATH = "src/main/resources/xml/Exported/ordered-customers.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ModelMapper modelMapper, XmlParser xmlParser
            ,CustomerRepository customerRepository) {

        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public void seedCustomers() throws JAXBException {
        CustomerImportRootDto customerImportRootDto = this.xmlParser
                .parseXml(CustomerImportRootDto.class, CUSTOMER_PATH);

        for (CustomerImportDto customerDto : customerImportRootDto.getCustomers()) {

            this.customerRepository.saveAndFlush(this.modelMapper.map(customerDto,Customer.class));
        }

    }

    @Override
    public void exportOrdered() throws JAXBException {

        List<CustomerOrderedExportDto> dtos=this.customerRepository.findAllSort()
                .stream()
                .map(c-> modelMapper.map(c,CustomerOrderedExportDto.class))
                .collect(Collectors.toList());

        CustomerOrderedRootExportDto rootDto= new CustomerOrderedRootExportDto();
        rootDto.setCustomers(dtos);

        this.xmlParser.exportXml(rootDto, CustomerOrderedRootExportDto.class,CUSTOMERS_ORDERED_PATH);




//        this.xmlParser.exportXml();
    }


}
