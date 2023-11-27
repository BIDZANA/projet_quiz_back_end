package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    @Query("SELECT r FROM Response r WHERE r.question.id_question = :questionId")
    List<Response> findByIdQuestion(@Param("questionId") Long questionId);
}
