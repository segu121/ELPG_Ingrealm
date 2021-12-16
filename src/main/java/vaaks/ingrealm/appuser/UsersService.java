package vaaks.ingrealm.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.login.LoginRequest;
import vaaks.ingrealm.registration.token.ConfirmationToken;
import vaaks.ingrealm.registration.token.ConfirmationTokenService;
import vaaks.ingrealm.security.PasswordEncoder;
import vaaks.ingrealm.utill.Message;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository userRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private final PasswordEncoder passwordEncoder;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String singInUser(Users appUser) {
        boolean userExists = userRepository.findByEmail(appUser.getEmail())
                .isPresent();
        System.out.println(appUser.getEmail());
        System.out.println(userExists);
        if (userExists) {
            throw  new IllegalStateException("email already taken");
        }
        String h_Pass = passwordEncoder.bCryptPasswordEncoder().encode(appUser.getPassword());
        appUser.setH_pass(h_Pass);
        userRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //TODO: send email
        return token;
    }

    public Message singUpUser(LoginRequest loginRequest, UserDetails user) {

        boolean userExists = userRepository.findByEmail(loginRequest.getEmail())
                .isPresent();


        if (!userExists) {
            throw  new IllegalStateException("invalid email");
        } else {
            String userPass = String.valueOf(user.getPassword());
            String requestPass  = loginRequest.getPassword();
            System.out.println("database pass:  " + userPass);
            System.out.println("password from request:  " + requestPass);
            boolean checkedPass = passwordEncoder.passwordMatchers(requestPass, userPass);
            System.out.println(checkedPass);
            if (checkedPass) {
                //TODO: save dateTime to dataBase, do authentication key to Users,
                return new Message("logged");
            } else {
                throw new IllegalStateException("invalid password");
            }
        }
    }
}
