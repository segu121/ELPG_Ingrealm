package vaaks.ingrealm.date.products.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String producer;
    private int productRating;

    @OneToMany
    private List<Ingredient> productIngredients;
//    private String productIngredients;
    private long userId;
    private String productImage;
    private int categoryId;
}

