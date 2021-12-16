package vaaks.ingrealm.login;

import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;
import vaaks.ingrealm.registration.RegistrationRequest;
import vaaks.ingrealm.utill.Message;

import javax.security.auth.message.callback.SecretKeyCallback;

@RestController
@RequestMapping(value = "/login", produces = "application/json; charset=UTF-8")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    @ResponseBody
    public String login(@RequestBody LoginRequest request) {
        System.out.println(request);
        Message userLoggedOr = loginService.loginUser(request);
        return userLoggedOr.getMessage();
    }

}
