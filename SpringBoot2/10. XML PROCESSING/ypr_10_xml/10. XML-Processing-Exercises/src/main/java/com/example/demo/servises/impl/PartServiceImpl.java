package com.example.demo.servises.impl;

import com.example.demo.domaint.dtos.importDtos.PartImportDto;
import com.example.demo.domaint.dtos.importDtos.PartImportRootDto;
import com.example.demo.domaint.entities.Part;
import com.example.demo.domaint.entities.Supplier;
import com.example.demo.domaint.repositories.PartRepository;
import com.example.demo.domaint.repositories.SupplierRepository;
import com.example.demo.servises.PartService;
import com.example.demo.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.Optional;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final static String PART_PATH = "src/main/resources/xml/parts.xml";

    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;


    @Autowired
    public PartServiceImpl(ModelMapper modelMapper, PartRepository partRepository, SupplierRepository supplierRepository, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;

        this.xmlParser = xmlParser;
    }

    @Override
    public void seedParts() throws Exception {

        PartImportRootDto partImportRootDto = this.xmlParser.parseXml(PartImportRootDto.class, PART_PATH);

        for (PartImportDto partDto : partImportRootDto.getParts()) {

            Part part=this.modelMapper.map(partDto,Part.class);

            part.setSupplier(this.getRandomSupplier());

            this.partRepository.saveAndFlush(part);
        }

    }




    private Supplier getRandomSupplier() throws Exception {
        Random random = new Random();

        long index = random.nextInt((int) this.supplierRepository.count()) + 1;

        Optional<Supplier> supplier = this.supplierRepository.findById(index);

        if (supplier.isPresent()) {
            return supplier.get();
        } else {
            throw new Exception("Supplier doesn't exist");
        }

    }


}
