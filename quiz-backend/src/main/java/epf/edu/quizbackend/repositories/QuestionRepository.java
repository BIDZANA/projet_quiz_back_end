package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.quiz.id_quiz = :quizId")
    List<Question> findByIdQuiz(@Param("quizId") Long quizId);
}
