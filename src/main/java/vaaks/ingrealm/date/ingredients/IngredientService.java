package vaaks.ingrealm.date.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.date.ingredients.IngredientRepository;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import java.util.List;

@Service
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
        return repository.findById(id).orElseThrow();
    }

    public Ingredient create(Ingredient ingredient) {
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
