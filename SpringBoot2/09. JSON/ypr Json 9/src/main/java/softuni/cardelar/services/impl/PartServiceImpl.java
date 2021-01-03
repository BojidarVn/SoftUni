package softuni.cardelar.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardelar.domain.dtos.export.PartSeedDto;
import softuni.cardelar.domain.entities.Part;
import softuni.cardelar.domain.entities.Supplier;
import softuni.cardelar.domain.repositories.PartRepository;
import softuni.cardelar.domain.repositories.SupplierRepository;
import softuni.cardelar.services.PartService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final static String PARTS_PATH = "src/main/resources/json/parts.json";

    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedPart() throws Exception {
        //content
        String content = String.join("", Files.readAllLines(Path.of(PARTS_PATH)));

        //dto
        PartSeedDto[] partSeedDtos = this.gson.fromJson(content, PartSeedDto[].class);

        //save
        for (PartSeedDto partSeedDto : partSeedDtos) {
            Part part = this.modelMapper.map(partSeedDto, Part.class);
            part.setSupplier(getRandomSupplier());

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
            throw new Exception("Supplier don't exist");
        }

    }

}












































