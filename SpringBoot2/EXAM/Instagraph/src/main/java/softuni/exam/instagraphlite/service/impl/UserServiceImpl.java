package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.models.importJson.UserImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final static String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           Gson gson, ValidatorUtil validatorUtil,
                           ModelMapper modelMapper, PictureRepository pictureRepository) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
    }


    @Override
    public Boolean аreImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(USERS_FILE_PATH)));
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder resultInfo = new StringBuilder();

        UserImportDto[] importDto = this.gson.fromJson(readFromFileContent(), UserImportDto[].class);

        for (UserImportDto userCheck : importDto) {

            if (this.validatorUtil.isValid(userCheck)) {

                if (this.userRepository.findFirstByUsername(userCheck.getUsername()) == null) {

                    User user = this.modelMapper.map(userCheck, User.class);

                    Picture picture = this.pictureRepository.findFirstByPath(userCheck.getProfilePicture());

                    if (this.pictureRepository.findFirstByPath(userCheck.getProfilePicture()) != null) {

                        user.setProfilePicture(picture);

                        this.userRepository.saveAndFlush(user);

                        resultInfo.append(String.format("Successfully imported User: %s", userCheck.getUsername()));
                    } else {
                        resultInfo.append("Invalid User");
                    }

                } else {
                    resultInfo.append("Al ready in DB");
                }
            } else {
                resultInfo.append("Invalid User");
            }

            resultInfo.append(System.lineSeparator());

        }

        return resultInfo.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {

        StringBuilder resultInfo=new StringBuilder();

        Set<User> users =this.userRepository.findAllUsersWithTheirPosts();

        for (User user : users) {



        }


        return resultInfo.toString();
    }
}





















