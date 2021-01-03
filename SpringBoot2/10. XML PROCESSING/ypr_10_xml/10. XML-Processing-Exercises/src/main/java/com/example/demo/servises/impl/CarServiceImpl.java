package com.example.demo.servises.impl;

import com.example.demo.domaint.dtos.export.CarExportDto;
import com.example.demo.domaint.dtos.export.CarExportRootDto;
import com.example.demo.domaint.dtos.export.PartExportDto;
import com.example.demo.domaint.dtos.export.PartExportRootDto;
import com.example.demo.domaint.dtos.importDtos.CarImportDto;
import com.example.demo.domaint.dtos.importDtos.CarImportRootDto;
import com.example.demo.domaint.entities.Car;
import com.example.demo.domaint.entities.Part;
import com.example.demo.domaint.repositories.CarRepository;
import com.example.demo.domaint.repositories.PartRepository;
import com.example.demo.servises.CarService;
import com.example.demo.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final static String CAR_PATH = "src/main/resources/xml/cars.xml";
    private final static String CARS_PARTS_PATH = "src/main/resources/xml/Exported/customers-total-sales.xml";

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;


    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository, PartRepository partRepository, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.partRepository = partRepository;

        this.xmlParser = xmlParser;
    }


    @Override

    public void seedCars() throws Exception {

        CarImportRootDto carImportRootDto = this.xmlParser.parseXml(CarImportRootDto.class, CAR_PATH);

        for (CarImportDto carDto : carImportRootDto.getCars()) {

            Car car = this.modelMapper.map(carDto, Car.class);

            car.setParts(this.getRandomParts());

            this.carRepository.saveAndFlush(car);
        }

    }

    @Override
    public void carsAndParts() throws JAXBException {
// query
        List<Car> all = this.carRepository.findAll();

//        kakvo iskam da poloy4a nakraq
        CarExportRootDto carRootDto = new CarExportRootDto();
        List<CarExportDto> carExportDtos = new ArrayList<>();

// make mode distance
        for (Car car : all) {
            CarExportDto carExportDto = this.modelMapper.map(car, CarExportDto.class);

            carExportDtos.add(carExportDto);
        }

        carRootDto.setCars(carExportDtos);

        this.xmlParser.exportXml(carRootDto, CarExportRootDto.class, CARS_PARTS_PATH);

    }




//    @Override
//    public void carsAndParts() throws JAXBException {
//// query
//        List<Car> all = this.carRepository.findAll();
//
////        kakvo iskam da poloy4a nakraq
//        CarExportRootDto carRootDto = new CarExportRootDto();
//        List<CarExportDto> carExportDtos = new ArrayList<>();
//
//// make mode distance
//        for (Car car : all) {
//            CarExportDto carExportDto = this.modelMapper.map(car, CarExportDto.class);
//
////    parts         logikata na kolata i 4astite e edinti4na samo 4e 4astite se vurtqt za vsqka kola
////
////            PartExportRootDto partExportRootDto = new PartExportRootDto();
////            List<PartExportDto> partExportDtos = new ArrayList<>();
////
////            for (Part part : car.getParts()) {
////                PartExportDto partDto = this.modelMapper.map(part, PartExportDto.class);
////                partExportDtos.add(partDto);
////            }
////
////            partExportRootDto.setParts(partExportDtos);
////            carExportDto.setParts(partExportRootDto);
//            carExportDtos.add(carExportDto);
//        }
//
//        carRootDto.setCars(carExportDtos);
//
//        this.xmlParser.exportXml(carRootDto, CarExportRootDto.class, CARS_PARTS_PATH);
//
//
//    }





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
        long index = random.nextInt((int) this.partRepository.count()) + 1;
        Optional<Part> part = this.partRepository.findById(index);

        if (part.isPresent()) {
            return part.get();
        } else {
            throw new Exception("Invalid!");
        }
    }


}































































