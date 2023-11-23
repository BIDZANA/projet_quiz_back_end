package epf.edu.quizbackend.services.impl;

import epf.edu.quizbackend.entities.Game;
import epf.edu.quizbackend.dto.GameDTO;
import epf.edu.quizbackend.repositories.GameRepository;
import epf.edu.quizbackend.services.IGameService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements IGameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game createGame(GameDTO gameDTO) {
        Game game = new Game();
        BeanUtils.copyProperties(gameDTO, game);
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Long id, GameDTO gameDTO) {
        Game existingGame = gameRepository.findById(id).orElse(null);
        if (existingGame != null) {
            BeanUtils.copyProperties(gameDTO, existingGame);
            return gameRepository.save(existingGame);
        }
        return null;
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}