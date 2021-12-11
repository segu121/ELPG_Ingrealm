//package vaaks.ingrealm.date.users;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import vaaks.ingrealm.date.users.dto.UserAdminDTO;
//import vaaks.ingrealm.date.users.user.User;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//public class UserController {
//
//    private final UserService service;
//
//    @Autowired
//    public UserController(UserService service) {
//        this.service = service;
//    }
//
//
//    @GetMapping("/users")
//    public List<UserAdminDTO> get(){
//        return service.getAll().stream()
//                .map(UserAdminDTO::of)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/users/{id}")
//    public UserAdminDTO get(@PathVariable long id){
//        return UserAdminDTO.of(service.get(id));
//    }
//
//    @PostMapping("/users")
//    public UserAdminDTO create(@RequestBody UserAdminDTO dto){
//        return UserAdminDTO.of(service.create(dto.toUser()));
//    }
//
//    @PutMapping("/users/{id}")
//    public UserAdminDTO modify(@PathVariable long id, @RequestBody UserAdminDTO dto){
//        User user = service.update(id, dto.toUser());
//        return UserAdminDTO.of(user);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/users/{id}")
//    public void delete(@PathVariable long id){
//        service.delete(id);
//    }
//
//
//
//
//
//
//
//
//
//}
//
