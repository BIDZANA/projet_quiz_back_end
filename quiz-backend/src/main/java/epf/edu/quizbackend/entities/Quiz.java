package epf.edu.quizbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quiz;
    private String theme;
    private String title;
    private String description;
    private String image;
    private String level;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<Game> games;
}
