package epf.edu.quizbackend.services.impl;

import epf.edu.quizbackend.entities.User;
import epf.edu.quizbackend.exceptions.UserServiceException;
import epf.edu.quizbackend.repositories.UserRepository;
import epf.edu.quizbackend.services.IUserService;

import java.util.Optional;

public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        // Vérifier si le nom d'utilisateur n'est pas déjà utilisé
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new UserServiceException("Le nom d'utilisateur est déjà pris.");
        }
        else{
            return userRepository.save(user);
        }
    }
}
