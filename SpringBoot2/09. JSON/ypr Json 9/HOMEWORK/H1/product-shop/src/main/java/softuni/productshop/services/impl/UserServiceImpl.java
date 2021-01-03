package softuni.productshop.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.productshop.domain.dtos.importedDtos.UserImportDto;
import softuni.productshop.domain.entities.User;
import softuni.productshop.repositories.UserRepository;
import softuni.productshop.services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    
    private final static String USER_PATH = "src/main/resources/jsons/users.json";

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsersInDB() throws IOException {
        String content = String.join("", Files.readAllLines(Path.of(USER_PATH)));
        
        UserImportDto[] userImportDto = this.gson.fromJson(content, UserImportDto[].class);

        for (UserImportDto importDto : userImportDto) {
            User user = this.modelMapper.map(importDto, User.class);

            this.userRepository.saveAndFlush(user);
        }
    }
}
