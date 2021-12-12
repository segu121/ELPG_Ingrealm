package vaaks.ingrealm.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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
        // TODO: Send confirmation token
        return "it works";
    }

}
