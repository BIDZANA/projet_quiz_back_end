package epf.edu.quizbackend.services;

import epf.edu.quizbackend.entities.Game;
import epf.edu.quizbackend.dto.GameDTO;

import java.util.List;

public interface IGameService {

    List<Game> getAllGames();

    Game getGameById(Long id);

    Game createGame(GameDTO gameDTO);

    Game updateGame(Long id, GameDTO gameDTO);

    void deleteGame(Long id);
}
