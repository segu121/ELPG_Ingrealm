package vaaks.ingrealm.date.ingredients;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.date.ingredients.IngredientRepository;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;


import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class IngredientService  {

    private final IngredientRepository repository;

    @Autowired
    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public List<Ingredient> getAll() {
        return repository.findAll();
    }

    public Ingredient get(long id) {
        log.info("getting ingredient id=" + id);
        return repository.findById(id).orElseThrow();
    }

    public Ingredient create(Ingredient ingredient) {
        log.info("creating ingredient name=" + ingredient.getName());
        return repository.save(ingredient);
    }

    public Ingredient update(long id, Ingredient ingredient) {
        Ingredient ingredientFromDb = get(id);
        ingredientFromDb.setName(ingredient.getName());
        ingredientFromDb.setRating(ingredient.getRating());
        ingredientFromDb.setDescription(ingredient.getDescription());
        return repository.save(ingredientFromDb);
    }

    public void delete(long id) {repository.delete(get(id));}

}
