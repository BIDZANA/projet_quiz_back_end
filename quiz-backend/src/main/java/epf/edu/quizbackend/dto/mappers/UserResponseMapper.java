package epf.edu.quizbackend.dto.mappers;

import epf.edu.quizbackend.dto.UserResponseDTO;
import epf.edu.quizbackend.entities.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {

    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    @Mapping(source = "id.userId", target = "id_user")
    @Mapping(source = "id.responseId", target = "id_response")
    @Mapping(source = "id.gameId", target = "id_game")
    UserResponseDTO userResponseToUserResponseDTO(UserResponse userResponse);

    @Mapping(source = "id_user", target = "id.userId")
    @Mapping(source = "id_response", target = "id.responseId")
    @Mapping(source = "id_game", target = "id.gameId")
    UserResponse userResponseDTOToUserResponse(UserResponseDTO userResponseDTO);
}

