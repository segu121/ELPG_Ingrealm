package vaaks.ingrealm.date.product;

import lombok.*;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String producer;
    private double rating;
    private Long userId;

   @OneToMany
    private List<Ingredient> ingredients;




}
