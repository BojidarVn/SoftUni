package softuni.cardealer.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardealer.domain.dtos.export.CarAndPartExportDto;
import softuni.cardealer.domain.dtos.export.CarExportDto;
import softuni.cardealer.domain.dtos.export.PartExportDto;
import softuni.cardealer.domain.dtos.importDtos.CarSeedDto;
import softuni.cardealer.domain.entities.Car;
import softuni.cardealer.domain.entities.Part;
import softuni.cardealer.domain.repositories.CarRepository;
import softuni.cardealer.domain.repositories.PartRepository;
import softuni.cardealer.services.CarService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final ModelMapper modelMapper;
    private final static String CAR_PATH = "src/main/resources/json/cars.json";
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository, PartRepository partRepository, Gson gson) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.gson = gson;
    }

    @Override
    public void seedCarsInDB() throws Exception {
        String content = String.join("", Files.readAllLines(Path.of(CAR_PATH)));
        CarSeedDto[] carSeedDtos = this.gson.fromJson(content, CarSeedDto[].class);

        for (CarSeedDto carSeedDto : carSeedDtos) {
            Car car = this.modelMapper.map(carSeedDto, Car.class);
            car.setParts(getRandomParts());

            this.carRepository.saveAndFlush(car);
        }
    }

    @Override
    public String getToyotaCars(String maker) {
        Set<Car> allByMakeOrderByModelAscTravelledDistanceDesc =
                this.carRepository.getAllByMakeOrderByModelAscTravelledDistanceDesc(maker);

        List<CarExportDto> toExport = new ArrayList<>();
        for (Car car : allByMakeOrderByModelAscTravelledDistanceDesc) {
            CarExportDto carExportDto = this.modelMapper.map(car, CarExportDto.class);
            toExport.add(carExportDto);
        }

        System.out.println();
        return this.gson.toJson(toExport);
    }

    @Override
    public String getCarsWithParts() {
        Set<Car> allBy = this.carRepository.getAllBy();

        List<CarAndPartExportDto> toExport = new ArrayList<>();
        for (Car car : allBy) {
            CarAndPartExportDto carAndPartExportDto = this.modelMapper.map(car, CarAndPartExportDto.class);
            PartExportDto partExportDto = new PartExportDto();
            List<PartExportDto> partExportDtos = new ArrayList<>();

            for (Part part : car.getParts()) {
                partExportDto = this.modelMapper.map(part, PartExportDto.class);
                partExportDtos.add(partExportDto);
            }


            carAndPartExportDto.setParts(partExportDtos);
            toExport.add(carAndPartExportDto);
        }

        return this.gson.toJson(toExport);
    }

    private Set<Part> getRandomParts() throws Exception {
        Set<Part> parts = new HashSet<>();
        for (int i = 0; i < 1; i++) {               //tyka trqbva da e "i < 3"
            Part part = this.getRandomPart();
            parts.add(part);
        }
        return parts;
    }

    private Part getRandomPart() throws Exception {
        Random random = new Random();
        long index = random.nextInt((int) this.partRepository.count()) + 1;
        Optional<Part> part = this.partRepository.findById(index);

        if (part.isPresent()) {
            return part.get();
        } else {
            throw new Exception("Invalid!");
        }
    }
}