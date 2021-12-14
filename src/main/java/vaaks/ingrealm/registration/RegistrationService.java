package vaaks.ingrealm.registration;


import lombok.AllArgsConstructor;
//import org.apache.logging.log4j.core.config.builder.api.Component;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vaaks.ingrealm.appuser.AppUserRole;
import vaaks.ingrealm.appuser.Users;
import vaaks.ingrealm.appuser.UsersService;
import vaaks.ingrealm.registration.token.ConfirmationToken;
import vaaks.ingrealm.registration.token.ConfirmationTokenService;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;
import

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UsersService appUserService;
    private final EmailValidate emailValidate;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidate.test(request.getEmail());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(calendar.getTime()));
        if(isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.singUpUser(
                new Users(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getSurrName(),
                        request.getNick(),
                        new Point(4329708,  1702067),
                        calendar.getTime(),
                        true,
                        AppUserRole.USER
                ));
    }
    @Transactional
    public String confirmationToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmed() != null) {
            throw new IllegalStateException("Email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

//        if(expiredAt.isBefore(LocalDateTime.now())) {
//            throw new IllegalStateException("token expired");
//        }
//        confirmationTokenService.setConfirmedAt(token);
//        appUserService.enableUsers(confirmationToken.getUser().getEmail());

        return "confirmed";
    }
}


