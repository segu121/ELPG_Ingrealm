package vaaks.ingrealm.appuser;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.login.LoginRequest;
import vaaks.ingrealm.token.ConfirmationToken;
import vaaks.ingrealm.token.ConfirmationTokenService;
import vaaks.ingrealm.utill.Message;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
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
        String h_Pass = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setH_pass(h_Pass);
        userRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //TODO: send email
        return "save";
    }

    public Message singUpUser(LoginRequest loginRequest, UserDetails user) {

        boolean userExists = userRepository.findByEmail(loginRequest.getEmail())
                .isPresent();


        if (!userExists) {
            throw  new IllegalStateException("invalid email");
        } else {
            String userPass = String.valueOf(user.getPassword());
            String requestPass  = String.valueOf(loginRequest.getPassword());
            System.out.println("database pass:  " + userPass);
            System.out.println("password from request:  " + requestPass);
            boolean checkedPass = bCryptPasswordEncoder.matches(requestPass, userPass);
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
