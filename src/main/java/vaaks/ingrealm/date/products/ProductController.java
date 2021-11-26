package vaaks.ingrealm.date.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaaks.ingrealm.date.ingredients.dto.IngredientAdminDTO;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

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
    public List<IngredientAdminDTO> get(){
        return service.getAll().stream()
                .map(IngredientAdminDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public IngredientAdminDTO get(@PathVariable long id){
        return IngredientAdminDTO.of(service.get(id));
    }

    @PostMapping("/products")
    public IngredientAdminDTO create(@RequestBody IngredientAdminDTO dto){
        return IngredientAdminDTO.of(service.create(dto.toIngredient()));
    }

    @PutMapping("/products/{id}")
    public IngredientAdminDTO modify(@PathVariable long id, @RequestBody IngredientAdminDTO dto){
        Ingredient ingredient = service.update(id, dto.toIngredient());
        return IngredientAdminDTO.of(ingredient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}

