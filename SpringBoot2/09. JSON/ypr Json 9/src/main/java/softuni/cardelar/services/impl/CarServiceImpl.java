package softuni.cardelar.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.cardelar.domain.dtos.export.CarExportDto;
import softuni.cardelar.domain.dtos.importDtos.CarSeedDto;
import softuni.cardelar.domain.entities.Car;
import softuni.cardelar.domain.entities.Part;
import softuni.cardelar.domain.repositories.CarRepository;
import softuni.cardelar.domain.repositories.PartRepository;
import softuni.cardelar.services.CarService;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final static String CAR_PATH = "src/main/resources/json/cars.json";

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    @Transactional
    public void seedCars() throws Exception {

        //content
        String content = String.join("", Files.readAllLines(Path.of(CAR_PATH)));

        //dto
        CarSeedDto[] carSeedDtos = this.gson.fromJson(content, CarSeedDto[].class);

        //save

        for (CarSeedDto carSeedDto : carSeedDtos) {
            Car car = this.modelMapper.map(carSeedDto, Car.class);
            car.setParts(getRandomParts());

            this.carRepository.saveAndFlush(car);
        }

    }

    @Override
    public String findByToyota() {
        Set<Car> toyota = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");

        List<CarExportDto> carExportDtos= new ArrayList<>();
        for (Car car : toyota) {
            CarExportDto carExportDto=this.modelMapper.map(car,CarExportDto.class);
            carExportDtos.add(carExportDto);
        }

        return this.gson.toJson(carExportDtos);
    }

    private Set<Part> getRandomParts() throws Exception {
        Set<Part> parts = new HashSet<>();



        for (int i = 0; i < 3; i++) {
            Part part = this.getRandomPart();
            parts.add(part);
        }
        return parts;

    }

    private Part getRandomPart() throws Exception {
        Random random = new Random();
        long index = (long) random.nextInt((int) this.partRepository.count()) + 1;

        Optional<Part> part = this.partRepository.findById(index);

        if (part.isPresent()) {
            return part.get();
        } else {
            throw new Exception("Something wrong");
        }

    }
}




































