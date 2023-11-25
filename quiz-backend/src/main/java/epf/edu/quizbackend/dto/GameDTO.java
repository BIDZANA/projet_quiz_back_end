package epf.edu.quizbackend.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Long id_game;
    private Date date;
    private Integer score;
    private Long id_quiz;
}
