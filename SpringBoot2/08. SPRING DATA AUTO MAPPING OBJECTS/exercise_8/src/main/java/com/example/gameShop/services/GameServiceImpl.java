package com.example.gameShop.services;

import com.example.gameShop.domain.dtos.AddGameDto;
import com.example.gameShop.domain.dtos.DeleteGameDto;
import com.example.gameShop.domain.dtos.UserDto;
import com.example.gameShop.domain.entities.Game;
import com.example.gameShop.domain.entities.Role;
import com.example.gameShop.repositories.GameRepository;
import com.example.gameShop.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final ValidatorUtil validatorUtil;
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;

    @Autowired
    public GameServiceImpl(ValidatorUtil validatorUtil, GameRepository gameRepository, ModelMapper modelMapper) {
        this.validatorUtil = validatorUtil;
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addGame(AddGameDto addGameDto) {

        StringBuilder sb = new StringBuilder();
        if (this.userDto == null || this.userDto.getRole().equals(Role.USER)) {

            sb.append("Invalid logged in user.");

        } else if (this.validatorUtil.isValid(addGameDto)) {

            Game game = this.modelMapper.map(addGameDto, Game.class);

            this.gameRepository.saveAndFlush(game);

            sb.append(String.format("Added %s", game.getTitle()));

        } else {
            this.validatorUtil.violations(addGameDto)
                    .forEach(e -> sb.append(e.getMessage()).append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }

    @Override
    public void setLoggedUser(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String deleteGame(DeleteGameDto deleteGameDto) {


        StringBuilder sb = new StringBuilder();
        if (this.userDto == null || this.userDto.getRole().equals(Role.USER)) {

            sb.append("Invalid logged in user.");

        } else {
            Optional<Game> game = this.gameRepository.findById(deleteGameDto.getId());

            if (game.isPresent()) {

                this.gameRepository.delete(game.get());
                sb.append(String.format("Game %s was deleted", game.get().getTitle()));

            } else {
                sb.append("Cannot find game");
            }

        }


        return sb.toString();
    }
}
