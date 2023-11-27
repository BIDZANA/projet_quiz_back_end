package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
