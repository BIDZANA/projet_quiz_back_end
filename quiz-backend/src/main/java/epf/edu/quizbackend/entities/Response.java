package epf.edu.quizbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "response")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_response;

    private Boolean isValid;
    private String value;

    @ManyToOne
    @JoinColumn(name = "id_question")
    @JsonManagedReference
    private Question question;

    @OneToMany(mappedBy = "response")
    @JsonIgnore
    private List<UserResponse> userResponses;
}

