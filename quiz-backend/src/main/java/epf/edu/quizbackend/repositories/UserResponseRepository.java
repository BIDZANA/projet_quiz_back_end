package epf.edu.quizbackend.repositories;


import epf.edu.quizbackend.entities.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {
}
