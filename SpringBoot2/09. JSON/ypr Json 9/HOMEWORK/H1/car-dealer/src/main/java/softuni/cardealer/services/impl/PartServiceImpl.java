package softuni.cardealer.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.importDtos.PartSeedDto;
import softuni.cardealer.domain.entities.Part;
import softuni.cardealer.domain.entities.Supplier;
import softuni.cardealer.domain.repositories.PartRepository;
import softuni.cardealer.domain.repositories.SupplierRepository;
import softuni.cardealer.services.PartService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final ModelMapper modelMapper;
    private final String PART_PATH = "src/main/resources/json/parts.json";
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final Gson gson;

    @Autowired
    public PartServiceImpl(ModelMapper modelMapper, PartRepository partRepository, SupplierRepository supplierRepository, Gson gson) {
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.gson = gson;
    }

    @Override
    public void seedPartsInDB() throws IOException {
        String content = String.join("", Files.readAllLines(Path.of(PART_PATH)));
        PartSeedDto[] partSeedDtos = this.gson.fromJson(content, PartSeedDto[].class);

        for (PartSeedDto partSeedDto : partSeedDtos) {
            Part part = this.modelMapper.map(partSeedDto, Part.class);
            part.setSupplier(getRandomSupplier());

            this.partRepository.saveAndFlush(part);
        }
    }

    private Supplier getRandomSupplier() {
        Random random = new Random();
        long index = random.nextInt((int) this.supplierRepository.count()) + 1;

        Supplier supplier = this.supplierRepository.findById(index).get();


        return supplier;
    }
}
