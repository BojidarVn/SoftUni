package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.DTO.jason.PictureImportDto;
import softuni.exam.instagraphlite.models.DTO.entities.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PATH_PICTURES="src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Boolean areImported() {
        return this.pictureRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PATH_PICTURES));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        PictureImportDto[] pictureImportDtos = this.gson.fromJson(this.readFromFileContent()
                ,PictureImportDto[].class);

        Arrays.stream(pictureImportDtos)
                .forEach(dtos -> {
                    if(this.validatorUtil.isValid(dtos)){

                        if(this.pictureRepository.findByPath(dtos.getPath())==null){



                            Picture picture = this.modelMapper.map(dtos, Picture.class);

                            sb.append(String.format("Successfully imported Picture, with size %.2f", dtos.getSize()))
                                    .append(System.lineSeparator());
                            this.pictureRepository.saveAndFlush(picture);

                        }

                    }else {
                        sb.append("Invalid picture!").append(System.lineSeparator());
                    }
                });


        return sb.toString();
    }

    @Override
    public String exportPictures() {
        return null;
    }

    @Override
    public Picture getByPath(String path) {
        return this.pictureRepository.findByPath(path);
    }
}
