package epf.edu.quizbackend.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class UserResponseId implements Serializable {

    private Long userId;
    private Long responseId;
    private Long gameId;
}
