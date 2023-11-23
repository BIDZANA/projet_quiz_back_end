package epf.edu.quizbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_game;

    private Date date;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    @JsonManagedReference
    private Quiz quiz;

    @OneToMany(mappedBy = "game")
    @JsonIgnore
    private List<UserResponse> userResponses;
}

