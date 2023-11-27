package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz_Id_quiz(Long quizId);
}
