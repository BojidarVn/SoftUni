package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.DTO.jason.UserImportDto;
import softuni.exam.instagraphlite.models.DTO.entities.Picture;
import softuni.exam.instagraphlite.models.DTO.entities.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final String PATH_USERS= "src/main/resources/files/users.json";


    private final PictureService pictureService;
    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public UserServiceImpl(PictureService pictureService, UserRepository userRepository, Gson gson, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.pictureService = pictureService;
        this.userRepository = userRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Boolean аreImported() {
        return this.userRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PATH_USERS));
    }

    @Override
    public String importUsers() throws IOException {
       StringBuilder sb = new StringBuilder();

        UserImportDto[] userImportDtos = this.gson.fromJson(this.readFromFileContent(),
                UserImportDto[].class);



        Arrays.stream(userImportDtos)
                .forEach(dtos -> {

                    if(this.validatorUtil.isValid(dtos)){
                        if(this.userRepository.findFirstByUsername(dtos.getUsername()) == null){

                            Picture picture = this.pictureService.getByPath(dtos.getProfilePicture());
                            User user = this.modelMapper.map(dtos, User.class);
                            user.setProfilePicture(picture);

                            sb.append(String.format("Successfully imported user: %s", dtos.getUsername()))
                                    .append(System.lineSeparator());
                            this.userRepository.saveAndFlush(user);

                        }else {
                            sb.append("Already in db").append(System.lineSeparator());
                        }

                    } else {
                        sb.append("Invalid User").append(System.lineSeparator());
                    }
                });



        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        return null;
    }

    @Override
    public User getByName(String username) {
        return this.userRepository.findFirstByUsername(username);
    }
}
