//package vaaks.ingrealm.date.users.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import vaaks.ingrealm.date.users.user.User;
//
//import java.awt.*;
//import java.text.DateFormat;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserAdminDTO {
//    private long id;
//    private String name;
//    private String email;
//    private String h_pass;
//    private String surname;
//    private String nick;
//    private Point geolocation;
//    private DateFormat registerDate;
//    private Boolean primaryAdmin;
//
//    public User toUser() {
//        return User.builder()
//                .id(id)
//                .name(name)
//                .email(email)
//                .h_pass(h_pass)
//                .surname(surname)
//                .nick(nick)
//                .geolocation(geolocation)
//                .registerDate(registerDate)
//                .primaryAdmin(primaryAdmin)
//                .build();
//    }
////    private long id;
////
////    private String name;
////    private int naturalRating;
////    private String description;
////    private String INCIName;
////    private long categoryId;
////    private int rating;
//
//    public static UserAdminDTO of(User user) {
//        return new UserAdminDTO(
//                user.getId(),
//                user.getName(),
//                user.getEmail(),
//                user.getH_pass(),
//                user.getSurname(),
//                user.getNick(),
//                user.getGeolocation(),
//                user.getRegisterDate(),
//                user.getPrimaryAdmin()
//        );
//    }
//}
//
