package epf.edu.quizbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userresponse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @EmbeddedId
    private UserResponseId id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_response", insertable = false, updatable = false)
    private Response response;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_game", insertable = false, updatable = false)
    private Game game;
}