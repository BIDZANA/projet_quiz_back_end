package epf.edu.quizbackend.dto.mappers;

import epf.edu.quizbackend.dto.QuestionDTO;
import epf.edu.quizbackend.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(source = "quiz.id_quiz", target = "id_quiz")
    QuestionDTO questionToQuestionDTO(Question question);

    @Mapping(source = "id_quiz", target = "quiz.id_quiz")
    Question questionDTOToQuestion(QuestionDTO questionDTO);
}
