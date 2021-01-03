package com.example.gameShop.services;

import com.example.gameShop.domain.dtos.AddGameDto;
import com.example.gameShop.domain.dtos.DeleteGameDto;
import com.example.gameShop.domain.dtos.UserDto;


public interface GameService {
    String addGame(AddGameDto addGameDto);

    void setLoggedUser(UserDto userDto);

    String deleteGame(DeleteGameDto deleteGameDto);

}
