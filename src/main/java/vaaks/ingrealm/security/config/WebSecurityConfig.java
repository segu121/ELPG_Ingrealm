package vaaks.ingrealm.security.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import vaaks.ingrealm.appuser.UsersService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource(name = "usersService")
    private final UsersService appUserService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return  provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
//                That disable was in correctly way must be enabled when is register forms
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration/**", "/ingredients/**", "/login/**", "/categories/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin()
                .loginPage("/login-page")
                .permitAll()
                .defaultSuccessUrl("/admin-page", true)
                .and()
                .rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(25))
                .key("keyToHashContent")
                .and()
                .logout()
                .logoutUrl("logout-button")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("someName")
                .logoutSuccessUrl("/");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
