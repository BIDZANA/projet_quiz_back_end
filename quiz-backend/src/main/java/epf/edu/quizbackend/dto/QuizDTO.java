package epf.edu.quizbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizDTO {

    private Long id_quiz;
    private String theme;
}