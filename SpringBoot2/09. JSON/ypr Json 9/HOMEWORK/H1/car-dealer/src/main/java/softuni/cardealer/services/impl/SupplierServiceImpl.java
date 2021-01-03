package softuni.cardealer.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.export.SupplierExportDto;
import softuni.cardealer.domain.dtos.importDtos.SupplierSeedDto;
import softuni.cardealer.domain.entities.Supplier;
import softuni.cardealer.domain.repositories.SupplierRepository;
import softuni.cardealer.services.SupplierService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private static String SUPPLIER_PATH = "src/main/resources/json/suppliers.json";
    private final Gson gson;


    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public void seedSupplierInDB() throws IOException {
        String content = String.join("", Files.readAllLines(Path.of(SUPPLIER_PATH)));
        SupplierSeedDto[] supplierSeedDtos = gson.fromJson(content, SupplierSeedDto[].class);

        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            this.supplierRepository.saveAndFlush(this.modelMapper.map(supplierSeedDto, Supplier.class));
        }
    }

    @Override
    public String getLocalSuppliers() {
        Set<Supplier> allByImporterFalse = this.supplierRepository.getAllByImporterFalse();

        List<SupplierExportDto> toExport = new ArrayList<>();
        for (Supplier supplier : allByImporterFalse) {
            SupplierExportDto supplierExportDto =
                    this.modelMapper.map(supplier, SupplierExportDto.class);
            supplierExportDto.setPartsCount(supplier.getParts().size());
            toExport.add(supplierExportDto);
        }
        return this.gson.toJson(toExport);
    }
}
