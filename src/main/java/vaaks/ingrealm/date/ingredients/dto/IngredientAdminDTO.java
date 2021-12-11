package vaaks.ingrealm.date.ingredients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;
import vaaks.ingrealm.appuser.AppUser;

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
//    private Category categoryName;
    private int rating;

    public Ingredient toIngredient() {
        return Ingredient.builder()
                .id(id)
                .name(name)
                .naturalRating(naturalRating)
                .description(description)
                .INCIName(INCIName)
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
                ingredient.getRating()
        );
    }
}
