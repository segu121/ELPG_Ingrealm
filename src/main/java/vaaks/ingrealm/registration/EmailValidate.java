package vaaks.ingrealm.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidate implements Predicate<String> {



    @Override
    public boolean test(String s) {
        //TODO: Regex to validate
        return false;
    }

    @Override
    public Predicate<String> and(Predicate<? super String> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<String> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<String> or(Predicate<? super String> other) {
        return Predicate.super.or(other);
    }
}
