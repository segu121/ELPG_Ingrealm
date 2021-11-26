package vaaks.ingrealm.date.products.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String productIngredients;
    private long userId;
    private String productImage;
    private int categoryId;
}

