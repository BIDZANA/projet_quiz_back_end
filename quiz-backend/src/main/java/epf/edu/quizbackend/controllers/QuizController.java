package epf.edu.quizbackend.controllers;

import epf.edu.quizbackend.dto.mappers.QuizMapper;
import epf.edu.quizbackend.entities.Quiz;
import epf.edu.quizbackend.dto.QuizDTO;
import epf.edu.quizbackend.services.IQuizService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin("*")
@Validated
public class QuizController {

    private final IQuizService quizService;
    public static QuizMapper quizMapper;

    @GetMapping()
    public List<QuizDTO> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return quizzes.stream()
                .map(quizMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        return quiz != null
                ? ResponseEntity.ok().body(quizMapper.toDto(quiz))
                : ResponseEntity.notFound().build();
    }
    @GetMapping("/{theme}")
    public List<QuizDTO> getQuizByTheme(@PathVariable String theme){
        List<Quiz> quizzes = quizService.getQuizByTheme(theme);
        return quizzes.stream()
                .map(quizMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz createdQuiz = quizService.createQuiz(quizDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
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
