package vaaks.ingrealm.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Collections;




@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;
    private String name;
    private String email;
    private String h_pass;
    private String surname;
    private String nick;
    private Point geolocation;

    @DateTimeFormat
    private DateFormat registerDate;

    private Boolean primaryAdmin;
//    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;

    public AppUser(String name, String email, String h_pass, String surname, String nick, Point geolocation, DateFormat registerDate, Boolean primaryAdmin, AppUserRole appUserRole, Boolean locked, Boolean enabled) {
        this.name = name;
        this.email = email;
        this.h_pass = h_pass;
        this.surname = surname;
        this.nick = nick;
        this.geolocation = geolocation;
        this.registerDate = registerDate;
        this.primaryAdmin = primaryAdmin;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return h_pass;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
