package vaaks.ingrealm.date.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaaks.ingrealm.date.ingredients.dto.IngredientAdminDTO;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;
import vaaks.ingrealm.date.products.dto.ProductAdminDTO;
import vaaks.ingrealm.date.products.product.Product;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<ProductAdminDTO> get(){
        return service.getAll().stream()
                .map(ProductAdminDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ProductAdminDTO get(@PathVariable long id){
        return ProductAdminDTO.of(service.get(id));
    }

    @PostMapping("/products")
    public ProductAdminDTO create(@RequestBody ProductAdminDTO dto){
        return ProductAdminDTO.of(service.create(dto.toProduct()));
    }

    @PutMapping("/products/{id}")
    public ProductAdminDTO modify(@PathVariable long id, @RequestBody ProductAdminDTO dto){
        Product product = service.update(id, dto.toProduct());
        return ProductAdminDTO.of(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}

