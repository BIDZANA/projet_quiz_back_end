package epf.edu.quizbackend.dto.mappers;

import epf.edu.quizbackend.dto.QuizDTO;
import epf.edu.quizbackend.entities.Quiz;

public class QuizMapper {

    public QuizDTO toDto(Quiz quiz) {
        if (quiz == null) {return null; }

        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setTheme(quiz.getTheme());
        quizDTO.setDescription(quiz.getDescription());
        quizDTO.setImage(quiz.getImage());

        return quizDTO;
    }

    public Quiz toEntity(QuizDTO quizDTO) {
        if (quizDTO == null) {return null; }

        Quiz quiz = new Quiz();
        quiz.setTheme(quizDTO.getTheme());
        quiz.setDescription(quizDTO.getDescription());
        quiz.setImage(quizDTO.getImage());

        return quiz;
    }
}
