package epf.edu.quizbackend.controllers;

import epf.edu.quizbackend.entities.Response;
import epf.edu.quizbackend.services.IResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
@RequiredArgsConstructor
public class ResponseController {

    private final IResponseService responseService;

    @GetMapping("/byQuestion/{questionId}")
    public List<Response> getResponsesByQuestionId(@PathVariable Long questionId) {
        return responseService.getResponsesByQuestionId(questionId);
    }
}
