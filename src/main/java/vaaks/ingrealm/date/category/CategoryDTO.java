package vaaks.ingrealm.date.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private long id;
    private String name;
    private Set<Ingredient> ingredients;

    public Category toCategory() {
        return Category.builder()
                .id(id)
                .name(name)
                .ingredients(ingredients)
                .build();
    }

    public static CategoryDTO of(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getIngredients()
        );
    }
}
