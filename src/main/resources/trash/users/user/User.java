//package vaaks.ingrealm.date.users.user;
//
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.annotation.processing.Generated;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.awt.*;
//import java.text.DateFormat;
//
//@Data
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//    private String email;
//    private String h_pass;
//    private String surname;
//    private String nick;
//    private Point geolocation;
//
//    @DateTimeFormat
//    private DateFormat registerDate;
//
//    private Boolean primaryAdmin;
//
//
//}
