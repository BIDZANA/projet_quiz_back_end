package epf.edu.quizbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {

    private Long id_response;
    private Boolean isValid;
    private String value;
    private Long id_question;
}