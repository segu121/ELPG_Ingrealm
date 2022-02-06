package vaaks.ingrealm.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class PasswordEncoder {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


//    public Boolean passwordMatchers(String basePass, String hPass) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = bCryptPasswordEncoder();
//        return bCryptPasswordEncoder.matches(basePass, hPass);}
}
