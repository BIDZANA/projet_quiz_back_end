package epf.edu.quizbackend.dto.mappers;

import epf.edu.quizbackend.dto.ResponseDTO;
import epf.edu.quizbackend.entities.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseMapper {

    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    @Mapping(source = "question.id_question", target = "id_question")
    ResponseDTO responseToResponseDTO(Response response);

    @Mapping(source = "id_question", target = "question.id_question")
    Response responseDTOToResponse(ResponseDTO responseDTO);
}

