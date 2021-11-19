package vaaks.ingrealm.ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    private long id;
    private String name;
    private int rating;
    private String description;

    public Ingredient toIngredient() {
        return Ingredient.builder()
                .id(id)
                .name(name)
                .rating(rating)
                .description(description)
                .build();
    }

    public static IngredientDTO of(Ingredient ingredient) {
        return new IngredientDTO(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getRating(),
                ingredient.getDescription()
        );
    }
}
