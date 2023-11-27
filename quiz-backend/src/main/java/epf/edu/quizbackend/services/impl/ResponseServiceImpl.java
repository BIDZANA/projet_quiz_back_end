package epf.edu.quizbackend.services.impl;
import epf.edu.quizbackend.entities.Response;
import epf.edu.quizbackend.repositories.ResponseRepository;
import epf.edu.quizbackend.services.IResponseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements IResponseService {

    private final ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }
    @Override
    public List<Response> getResponsesByQuestionId(Long questionId) {
        return responseRepository.findByIdQuestion(questionId);
    }
}
