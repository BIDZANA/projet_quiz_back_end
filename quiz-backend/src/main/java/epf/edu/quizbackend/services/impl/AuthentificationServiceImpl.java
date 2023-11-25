package epf.edu.quizbackend.services.impl;

import epf.edu.quizbackend.dto.UserDTO;
import epf.edu.quizbackend.dto.mappers.UserMapper;
import epf.edu.quizbackend.entities.User;
import epf.edu.quizbackend.exceptions.AuthentificationException;
import epf.edu.quizbackend.repositories.UserRepository;
import epf.edu.quizbackend.services.IAuthentificationService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthentificationServiceImpl implements IAuthentificationService {

    private final JavaMailSender javaMailSender;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public AuthentificationServiceImpl(JavaMailSender javaMailSender, UserMapper userMapper, UserRepository userRepository) {
        this.javaMailSender = javaMailSender;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) throws AuthentificationException {
        try {
            System.out.println("Registration in progress ...");
            User user = new User();
            user.generateVerificationToken();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setEmailVerified(false);
            user.setRole(User.UserRole.USER);
            verifyEmail(userDTO.getEmail(), user.getVerificationToken());
            userRepository.save(user);
            System.out.println("Registration completed!");
            return userMapper.toDto(user);
        } catch (Exception e) {
            System.out.println("--Registration error--");
            throw new AuthentificationException(e);
        }
    }

    @Override
    public UserDTO signIn(String email) throws AuthentificationException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().isEmailVerified()) {
            return userMapper.toDto(user.get());
        } else {
            throw new AuthentificationException(new Exception());
        }
    }

    @Override
    public User getUserByVerificationToken(String token) {
        Optional<User> userOptional = userRepository.findByVerificationToken(token);
        return userOptional.orElseThrow(() -> new AuthentificationException(new Exception()));
    }

    @Override
    public void verifyEmail(String email, String verificationToken) {
        String subject = "Vérification de l'adresse e-mail";
        String verificationLink = "http://localhost:9090/api/authentification/verification?token=" + verificationToken;
        String body = "Bienvenue sur notre site! \nCliquez sur le lien suivant pour vérifier votre adresse e-mail : \n" + verificationLink;
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Vérification d'adresse e-mail");
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);
            System.out.println("email de vérification envoyé!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
