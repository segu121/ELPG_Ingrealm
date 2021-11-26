package vaaks.ingrealm.date.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.date.ingredients.IngredientRepository;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;
import vaaks.ingrealm.date.products.product.Product;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;


    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product get(long id) {
        return repository.findById(id).orElseThrow();
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public Product update(long id, Product product) {
        Product productFromDb = get(id);
        productFromDb.setName(product.getName());
        productFromDb.setProducer(product.getProducer());
        productFromDb.setProductRating(product.getProductRating());
        productFromDb.setProductIngredients(product.getProductIngredients());
        productFromDb.setUserId(product.getUserId());
        productFromDb.setProductImage(product.getProductImage());
        productFromDb.setCategoryId(product.getCategoryId());
        return repository.save(product);
    }

    public void delete(long id) {repository.delete(get(id));}
}
