package epf.edu.quizbackend.controllers;

import epf.edu.quizbackend.entities.Quiz;
import epf.edu.quizbackend.dto.QuizDTO;
import epf.edu.quizbackend.services.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin("*")
@Validated
public class QuizController {

    private final IQuizService quizService;

    @GetMapping()
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        return quiz != null
                ? ResponseEntity.ok().body(quiz)
                : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz createdQuiz = quizService.createQuiz(quizDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody QuizDTO quizDTO) {
        Quiz updatedQuiz = quizService.updateQuiz(id, quizDTO);
        return updatedQuiz != null
                ? ResponseEntity.ok().body(updatedQuiz)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
