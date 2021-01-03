package com.example.demo.servises.impl;


import com.example.demo.domaint.dtos.importDtos.SupplierImportDto;
import com.example.demo.domaint.dtos.importDtos.SupplierImportRootDto;
import com.example.demo.domaint.entities.Supplier;
import com.example.demo.domaint.repositories.SupplierRepository;
import com.example.demo.servises.SupplierService;
import com.example.demo.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final static String SUPPLIER_PATH = "src/main/resources/xml/suppliers.xml";

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;



    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public void seedSupplierInDB() throws IOException, JAXBException {
        SupplierImportRootDto supplierImportRootDto = this.xmlParser.parseXml(SupplierImportRootDto.class, SUPPLIER_PATH);

        for (SupplierImportDto supplier : supplierImportRootDto.getSupplier()) {
            this.supplierRepository.save(this.modelMapper.map(supplier, Supplier.class));

        }

    }
}
