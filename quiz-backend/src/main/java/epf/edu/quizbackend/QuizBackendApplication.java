package epf.edu.quizbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EntityScan(basePackages = "epf.edu.quizbackend.entities")
// @EnableJpaRepositories(basePackages = "epf.edu.quizbackend.repositories")
@EnableJpaAuditing
public class QuizBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizBackendApplication.class, args);
    }

}