package vaaks.ingrealm.date.ingredients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import java.util.List;

@Service
@Slf4j
public class IngredientService {

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
        ingredientFromDb.setINCIName(ingredient.getINCIName());
        ingredientFromDb.setCategories(ingredient.getCategories());
        ingredientFromDb.setDescription(ingredient.getDescription());
        ingredientFromDb.setNaturalRating(ingredient.getNaturalRating());
        ingredientFromDb.setRating(ingredient.getRating());
        return repository.save(ingredientFromDb);
    }

    public void delete(long id) {repository.delete(get(id));}

}
