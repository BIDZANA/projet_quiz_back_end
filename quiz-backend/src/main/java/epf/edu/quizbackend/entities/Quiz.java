package epf.edu.quizbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quiz;

    private String theme;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<Game> games;
}
