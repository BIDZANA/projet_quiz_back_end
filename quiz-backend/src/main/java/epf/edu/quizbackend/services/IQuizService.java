package epf.edu.quizbackend.services;

import epf.edu.quizbackend.entities.Quiz;
import epf.edu.quizbackend.dto.QuizDTO;

import java.util.List;

public interface IQuizService {

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Long id);

    List<Quiz> getQuizByTheme(String theme);

    Quiz createQuiz(QuizDTO quizDTO);

    Quiz updateQuiz(Long id, QuizDTO quizDTO);

    void deleteQuiz(Long id);
    List<String> getAllThemes();
}