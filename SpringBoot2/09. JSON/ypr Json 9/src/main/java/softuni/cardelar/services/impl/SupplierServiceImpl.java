package softuni.cardelar.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardelar.domain.dtos.importDtos.SupplierSeedDto;
import softuni.cardelar.domain.entities.Supplier;
import softuni.cardelar.domain.repositories.SupplierRepository;
import softuni.cardelar.services.SupplierService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final static String SUPPLIER_PATH="src/main/resources/json/suppliers.json";
    private final SupplierRepository supplierRepository;
    private final  ModelMapper modelMapper;
    private final Gson gson;


    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public void seedSupplier() throws IOException {

        //1.  Read Json    dolnoto e su6toto zapisano po dryg na4in

        String content= String.join("", Files.readAllLines(Path.of(SUPPLIER_PATH)));

//        String content= Files.readAllLines(Path.of("src/main/resources/json/suppliers.json"))
//                .stream()
//                .collect(Collectors.joining());

       //2.  JSON -> DTO
        SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(content, SupplierSeedDto[].class);

        //3.  DTO save db
        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            this.supplierRepository.saveAndFlush(this.modelMapper.map(supplierSeedDto, Supplier.class));
        }


    }
}





























