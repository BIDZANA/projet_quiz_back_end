package epf.edu.quizbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public enum UserRole {
        USER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String verificationToken;
    private String username;
    private String email;
    private boolean emailVerified = false;

    @Column(length = 20)
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserResponse> userResponses;

    public void generateVerificationToken() {
        this.verificationToken = UUID.randomUUID().toString();
    }
}
