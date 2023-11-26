package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findQuizByTheme(String theme);
    @Query(value = "SELECT DISTINCT theme FROM quiz", nativeQuery = true)
    List<String> findAllThemes();
}
