package vaaks.ingrealm.date.ingredients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientUserDTO {
    private long id;
    private String name;
    private String description;
    private String INCI_Name;
    //    private Category categoryName;


    public Ingredient toIngredient() {
        return Ingredient.builder()
                .id(id)
                .name(name)
                .description(description)
                .INCI_Name(INCI_Name)
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
