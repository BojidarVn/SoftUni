package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.importJson.PictureImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {

    private final static String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository
            , ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public Boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(PICTURE_FILE_PATH)));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder resultInfo = new StringBuilder();

        PictureImportDto[] importDto = this.gson.fromJson(readFromFileContent(), PictureImportDto[].class);

        for (PictureImportDto pictureForCheck : importDto) {

            if (this.validatorUtil.isValid(pictureForCheck)) {

                if (this.pictureRepository.findFirstByPath(pictureForCheck.getPath()) == null) {

                    Picture picture = this.modelMapper.map(pictureForCheck, Picture.class);

                    resultInfo.append(String.format("Successfully imported Picture, with size %.2f", pictureForCheck.getSize()));

                    this.pictureRepository.saveAndFlush(picture);

                } else {

                    resultInfo.append("Al ready in DB");
                }


            } else {

                resultInfo.append("Invalid Picture");
            }
            resultInfo.append(System.lineSeparator());

        }


        return resultInfo.toString();
    }


    @Override
    public String exportPictures() {

        StringBuilder resultInfo=new StringBuilder();

        Set<Picture> pictures=this.pictureRepository.pictureBiggerThen();

        for (Picture picture : pictures) {

            resultInfo.append(String.format("%.2f – %s",picture.getSize(),picture.getPath()));
            resultInfo.append(System.lineSeparator());
        }

        return resultInfo.toString();
    }
}



































