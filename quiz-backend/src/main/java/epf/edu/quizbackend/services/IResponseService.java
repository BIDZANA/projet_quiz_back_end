package epf.edu.quizbackend.services;

import epf.edu.quizbackend.entities.Response;

import java.util.List;

public interface IResponseService {
    List<Response> getResponsesByQuestionId(Long questionId);
}
