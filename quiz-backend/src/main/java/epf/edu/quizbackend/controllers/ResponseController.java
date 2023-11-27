package epf.edu.quizbackend.controllers;

import epf.edu.quizbackend.entities.Response;
import epf.edu.quizbackend.services.IResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/responses")
@CrossOrigin("*")
@Validated
public class ResponseController {

    private final IResponseService responseService;

    @GetMapping("/byQuestion/{questionId}")
    public List<Response> getResponsesByQuestionId(@PathVariable Long questionId) {
        return responseService.getResponsesByQuestionId(questionId);
    }
}
