package epf.edu.quizbackend.controllers;

import epf.edu.quizbackend.dto.UserDTO;
import epf.edu.quizbackend.entities.User;
import epf.edu.quizbackend.exceptions.AuthentificationException;
import epf.edu.quizbackend.services.IAuthentificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authentification")
@CrossOrigin()
@Validated
public class AuthentificationController {

    private final IAuthentificationService authentificationService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody @Valid UserDTO userDTO) {
        try {
            UserDTO newUser = authentificationService.signUp(userDTO);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (AuthentificationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/signin")
    public ResponseEntity<UserDTO> signIn(@RequestParam("email") String email) {
        try {
            UserDTO user = authentificationService.signIn(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (AuthentificationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/verification")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
        try {
            // Vérifiez le token dans la base de données
            User user = authentificationService.getUserByVerificationToken(token);

            if (user != null && !user.isEmailVerified()) {
                // Mise à jour du statut de vérification
                user.setEmailVerified(true);
                authentificationService.save(user);
                return ResponseEntity.ok("Adresse e-mail vérifiée avec succès!");
            } else if (user != null && user.isEmailVerified()) {
                // Le lien a déjà été utilisé
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse e-mail déjà vérifiée!");
            } else {
                // Le token est invalide ou expiré
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token invalide ou expiré.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la vérification de l'adresse e-mail.");
        }
    }
}
