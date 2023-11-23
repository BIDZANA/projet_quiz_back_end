package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
