package vaaks.ingrealm.date.ingredients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vaaks.ingrealm.date.category.Category;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientAdminDTO {
    private long id;
    private String name;
    private int naturalRating;
    private String description;
    private String INCIName;
    private Set<Category> categories;
    private int rating;

    public Ingredient toIngredient() {
        return Ingredient.builder()
                .id(id)
                .name(name)
                .naturalRating(naturalRating)
                .description(description)
                .INCIName(INCIName)
                .categories(categories)
                .rating(rating)
                .build();
    }

    public static IngredientAdminDTO of(Ingredient ingredient) {
        return new IngredientAdminDTO(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getNaturalRating(),
                ingredient.getDescription(),
                ingredient.getINCIName(),
                ingredient.getCategories(),
                ingredient.getRating()
        );
    }
}
