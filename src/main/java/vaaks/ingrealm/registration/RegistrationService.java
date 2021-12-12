package vaaks.ingrealm.registration;


import lombok.AllArgsConstructor;
//import org.apache.logging.log4j.core.config.builder.api.Component;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.appuser.AppUserRole;
import vaaks.ingrealm.appuser.Users;
import vaaks.ingrealm.appuser.UsersService;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UsersService appUserService;
    private final EmailValidate emailValidate;


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
                        AppUserRole.ADMIN,
                        true,
                        true
                ));
    }
}
