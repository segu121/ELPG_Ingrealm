package vaaks.ingrealm.security;

import liquibase.pro.packaged.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class PasswordEncoder {

//    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }


    public Boolean passwordMatchers(String basePass, String hPass) {
        BCryptPasswordEncoder bCryptPasswordEncoder = bCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(basePass, hPass);}
}
