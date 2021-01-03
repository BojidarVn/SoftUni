package com.example.gameShop.services;

import com.example.gameShop.domain.dtos.UserLoginDto;
import com.example.gameShop.domain.dtos.UserRegisterDto;

public interface UserService {

    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto loginDto);

    String logout();
}
