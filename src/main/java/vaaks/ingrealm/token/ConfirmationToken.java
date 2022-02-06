package vaaks.ingrealm.appuser.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import vaaks.ingrealm.appuser.Users;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;
    private String token;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;

    private LocalDateTime confirmed;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "users_id"
    )
    private Users user;

    public ConfirmationToken(String token,
                             LocalDateTime createAt,
                             LocalDateTime expiredAt,
                             Users user) {
        this.token = token;
        this.createAt = createAt;
        this.expiredAt = expiredAt;
    }
}
