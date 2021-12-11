package vaaks.ingrealm.registration;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.*;
import java.text.DateFormat;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String nick;
    private final String email;
    private final String password;
    private final String name;
    private final String lastName;
    private final String surrName;
    private final Point Geolocation;
    private final DateFormat registerDate;


}
