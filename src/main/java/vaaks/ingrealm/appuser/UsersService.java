package vaaks.ingrealm.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.registration.token.ConfirmationToken;
import vaaks.ingrealm.registration.token.ConfirmationTokenService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String singUpUser(Users appUser) {
        boolean userExists = userRepository.findByEmail(appUser.getEmail())
                .isPresent();
        System.out.println(appUser.getEmail());
        System.out.println(userExists);
        if (userExists) {
            throw  new IllegalStateException("email already taken");
        }
        String h_Pass = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setH_pass(h_Pass);
        userRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //TODO: send email
        return token;
    }

}
