package vaaks.ingrealm.date.products.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vaaks.ingrealm.date.ingredients.dto.IngredientAdminDTO;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;
import vaaks.ingrealm.date.products.product.Product;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductAdminDTO {

    private long id;
    private String name;
    private String producer;
    private int productRating;
    private String productIngredients;
    private String productImage;
    private int categoryId;

    public Product toProduct() {
        return Product.builder()
                .id(id)
                .name(name)
                .producer(producer)
                .productRating(productRating)
                .productIngredients(productIngredients)
                .productImage(productImage)
                .categoryId(categoryId)
                .build();
    }

    public static ProductAdminDTO of(Product product) {
        return new ProductAdminDTO(
                product.getId(),
                product.getName(),
                product.getProducer(),
                product.getProductRating(),
                product.getProductIngredients(),
                product.getProductImage(),
                product.getCategoryId()
        );
    }
}
