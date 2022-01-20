package vaaks.ingrealm.date.category;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vaaks.ingrealm.date.ingredients.IngredientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/categories")
    public List<CategoryDTO> get() {
        return service.getAll().stream()
                .map(CategoryDTO::of)
                .collect(Collectors.toList());
    }
}
