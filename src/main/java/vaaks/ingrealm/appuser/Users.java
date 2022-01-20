package vaaks.ingrealm.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vaaks.ingrealm.security.AppUserRole;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String h_pass;
    private String surname;
    private String nick;
    @Transient
    private Point geolocation;

    @DateTimeFormat
    private Date registerData;

    private Boolean primaryAdmin;
//    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    public Users(String name, String email, String h_pass, String surrName, String nick, Point geolocation, Date registerDate, Boolean primaryAdmin, AppUserRole appUserRole) {
        this.name = name;
        this.email = email;
        this.h_pass = h_pass;
        this.surname = surrName;
        this.nick = nick;
        this.geolocation = geolocation;
        this.registerData = registerDate;
        this.primaryAdmin = primaryAdmin;
        this.appUserRole = appUserRole;
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

    public String getEmail() {return email;}

    public String getSurname() {return surname;}
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

    private void setUserRole() {
        if (primaryAdmin) {
            this.appUserRole = AppUserRole.ADMIN;
        } else {
            this.appUserRole = AppUserRole.USER;
        }

    }
}
