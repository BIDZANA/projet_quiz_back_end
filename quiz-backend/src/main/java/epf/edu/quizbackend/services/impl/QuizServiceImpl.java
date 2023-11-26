package epf.edu.quizbackend.services.impl;

import epf.edu.quizbackend.entities.Quiz;
import epf.edu.quizbackend.dto.QuizDTO;
import epf.edu.quizbackend.repositories.QuizRepository;
import epf.edu.quizbackend.services.IQuizService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements IQuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public List<Quiz> getQuizByTheme(String theme) {
        return quizRepository.findQuizByTheme(theme);
    }

    @Override
    public Quiz createQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        BeanUtils.copyProperties(quizDTO, quiz);
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Long id, QuizDTO quizDTO) {
        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        if (existingQuiz != null) {
            BeanUtils.copyProperties(quizDTO, existingQuiz);
            return quizRepository.save(existingQuiz);
        }
        return null;
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public List<String> getAllThemes() {
        return quizRepository.findAllThemes();
    }
}
