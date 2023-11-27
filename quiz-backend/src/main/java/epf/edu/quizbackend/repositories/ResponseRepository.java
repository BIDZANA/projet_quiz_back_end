package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByQuestion_IdQuestion(Long questionId);
}
