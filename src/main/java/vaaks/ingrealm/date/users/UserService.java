package vaaks.ingrealm.date.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;
import vaaks.ingrealm.date.users.user.User;

import java.text.DateFormat;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User get(long id) {
        return repository.findById(id).orElseThrow();
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(long id, User user) {
        User userFromDb = get(id);
        userFromDb.setName(user.getName());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setH_pass(user.getH_pass());
        userFromDb.setSurname(user.getSurname());
        userFromDb.setNick(user.getNick());
        userFromDb.setGeolocation(user.getGeolocation());
        userFromDb.setRegisterDate(DateFormat.getDateTimeInstance());
        userFromDb.setPrimaryAdmin(user.getPrimaryAdmin());
        return repository.save(userFromDb);
    }

    public void delete(long id) {repository.delete(get(id));}

}

