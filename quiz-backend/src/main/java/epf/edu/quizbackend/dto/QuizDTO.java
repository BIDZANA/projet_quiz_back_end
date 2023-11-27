package epf.edu.quizbackend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String theme;
    private String title;
    private String description;
    private String image;
    private String level;
}