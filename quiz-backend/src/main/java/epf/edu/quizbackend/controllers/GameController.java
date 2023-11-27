package epf.edu.quizbackend.controllers;

import epf.edu.quizbackend.dto.UserResponseDTO;
import epf.edu.quizbackend.entities.Game;
import epf.edu.quizbackend.dto.GameDTO;
import epf.edu.quizbackend.services.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/games")
@CrossOrigin()
@Validated
public class GameController {

    private final IGameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Game game = gameService.getGameById(id);
        return game != null
                ? ResponseEntity.ok().body(game)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Game> saveGame(@RequestBody GameDTO gameDTO) {
        Game createdGame = gameService.createGame(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
    }

    @PostMapping("/start/{quizId}")
    public ResponseEntity<GameDTO> startGame(@PathVariable Long quizId) {
        // Logique pour commencer un nouveau jeu
        GameDTO gameDTO = gameService.startGame(quizId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @PostMapping("/submit-response")
    public ResponseEntity<GameDTO> submitResponse(@RequestBody UserResponseDTO userResponseDTO) {
        // Logique pour soumettre une réponse
        GameDTO updatedGame = gameService.submitResponse(userResponseDTO);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody GameDTO gameDTO) {
        Game updatedGame = gameService.updateGame(id, gameDTO);
        return updatedGame != null ?
                new ResponseEntity<>(updatedGame, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}