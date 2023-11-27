package epf.edu.quizbackend.dto.mappers;
import epf.edu.quizbackend.dto.GameDTO;
import epf.edu.quizbackend.entities.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "quiz.id_quiz", target = "id_quiz")
    GameDTO gameToGameDTO(Game game);

    @Mapping(target = "userResponses", ignore = true)
    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "id_quiz", target = "quiz.id_quiz")
    Game gameDTOToGame(GameDTO gameDTO);

    List<GameDTO> gamesToGameDTOs(List<Game> games);

    List<Game> gameDTOsToGames(List<GameDTO> gameDTOs);
}