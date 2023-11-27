package epf.edu.quizbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {

    private Long id_question;
    private String statement;
    private String image;
    private Long id_quiz;
}