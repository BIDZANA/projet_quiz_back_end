package epf.edu.quizbackend.repositories;

import epf.edu.quizbackend.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
