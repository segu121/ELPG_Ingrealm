package vaaks.ingrealm.login;

import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.appuser.UsersService;
import vaaks.ingrealm.utill.Message;

@Service
@AllArgsConstructor
public class LoginService {

    private final UsersService appUserService;

    public Message loginUser(LoginRequest loginRequest) {
        UserDetails user = appUserService.loadUserByUsername(loginRequest.getEmail());
        Message tryingLogin = appUserService.singUpUser(loginRequest, user);
        return tryingLogin;
    }
}
