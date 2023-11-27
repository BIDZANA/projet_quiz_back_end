package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
