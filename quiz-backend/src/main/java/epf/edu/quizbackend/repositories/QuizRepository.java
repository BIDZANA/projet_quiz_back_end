package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
