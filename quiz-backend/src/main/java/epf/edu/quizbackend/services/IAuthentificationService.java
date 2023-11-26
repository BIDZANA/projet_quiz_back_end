package epf.edu.quizbackend.services;

import epf.edu.quizbackend.dto.UserDTO;
import epf.edu.quizbackend.entities.User;
import epf.edu.quizbackend.exceptions.AuthentificationException;

public interface IAuthentificationService {

    UserDTO signIn(String username) throws AuthentificationException;

    UserDTO signUp(UserDTO dto) throws AuthentificationException;

    User getUserByVerificationToken(String token);

    void verifyEmail(String email, String verificationToken);

    void update(User user);
}
