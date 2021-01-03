package com.example.gameShop.services;

import com.example.gameShop.domain.dtos.UserDto;
import com.example.gameShop.domain.dtos.UserLoginDto;
import com.example.gameShop.domain.dtos.UserRegisterDto;
import com.example.gameShop.domain.entities.Role;
import com.example.gameShop.domain.entities.User;
import com.example.gameShop.repositories.UserRepository;
import com.example.gameShop.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private final GameService gameService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private UserDto loggedUser;


    @Autowired
    public UserServiceImpl(GameService gameService, ValidatorUtil validatorUtil
            , ModelMapper modelMapper, UserRepository userRepository) {
        this.gameService = gameService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        StringBuilder sb = new StringBuilder();

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            sb.append("Password don't match");
        } else if (this.validatorUtil.isValid(userRegisterDto)) {


            User user = this.modelMapper.map(userRegisterDto, User.class);

            if (this.userRepository.count() == 0) {
                user.setRole(Role.ADMIN);
            } else {
                user.setRole(Role.USER);
            }

            sb.append(String.format("%s was registered", userRegisterDto.getFullName()));

            this.userRepository.saveAndFlush(user);

        } else {

            this.validatorUtil.violations(userRegisterDto)
                    .forEach(e -> sb.append(String.format("%s%n", e.getMessage())));

        }
        System.out.println();

        return sb.toString().trim();


    }

    @Override
    public String loginUser(UserLoginDto loginDto) {
        StringBuilder sb = new StringBuilder();
        Optional<User> user = this.userRepository
                .findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());

        if (user.isPresent()) {
            if (this.loggedUser != null) {
                sb.append("User is already logged id");
            } else {
                this.loggedUser = this.modelMapper.map(user.get(), UserDto.class);

                this.gameService.setLoggedUser(this.loggedUser);

                sb.append(String.format("Successfully logged in %s", user.get().getFullName()));

            }

        } else {
            sb.append("Incorrect email/password");
        }

        return sb.toString();
    }

    @Override
    public String logout() {

        if (this.loggedUser == null) {
            return ("Cannot log out. No user was logged in.");
        } else {
            String message = String.format("User %s successfully logged out", loggedUser.getFullName());
            this.loggedUser = null;
            return message;
        }


    }
}
