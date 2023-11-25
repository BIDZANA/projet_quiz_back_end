package epf.edu.quizbackend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String theme;
    private String description;
    private String image;
}