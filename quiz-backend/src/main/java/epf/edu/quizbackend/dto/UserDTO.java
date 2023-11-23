package epf.edu.quizbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private Long id_user;
    private String username;
    private String email;
    private Boolean role;
}