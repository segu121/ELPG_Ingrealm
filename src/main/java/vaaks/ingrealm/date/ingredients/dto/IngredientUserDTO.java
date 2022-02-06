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
public class IngredientUserDTO {
    private long id;
    private String name;
    private String description;
    private String INCIName;
    private Set<Category> categories;


    public Ingredient toIngredient() {
        return Ingredient.builder()
                .id(id)
                .name(name)
                .description(description)
                .INCIName(INCIName)
                .categories(categories)
                .build();
    }
//    private long id;
//
//    private String name;
//    private int naturalRating;
//    private String description;
//    private String INCIName;
//    private long categoryId;
//    private int rating;


}
