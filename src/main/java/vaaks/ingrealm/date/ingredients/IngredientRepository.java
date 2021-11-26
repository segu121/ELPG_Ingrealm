package vaaks.ingrealm.date.ingredients;

import org.springframework.data.jpa.repository.JpaRepository;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
