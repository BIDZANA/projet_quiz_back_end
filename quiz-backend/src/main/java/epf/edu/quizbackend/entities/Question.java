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
@Table(name = "question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_question;
    private String statement;
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    @JsonManagedReference
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private List<Response> responses;
}

