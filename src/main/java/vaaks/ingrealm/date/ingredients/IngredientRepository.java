package vaaks.ingrealm.date.ingredients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
