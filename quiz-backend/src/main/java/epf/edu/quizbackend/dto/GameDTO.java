package epf.edu.quizbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class GameDTO {

    private Long id_game;
    private Date date;
    private Integer score;
    private Long id_quiz;
}
