package epf.edu.quizbackend.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Long id_game;
    private LocalDate date;
    private Integer score;
    private Long id_quiz;
}
