package vaaks.ingrealm.date.category;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vaaks.ingrealm.date.ingredients.IngredientService;
import vaaks.ingrealm.date.ingredients.dto.IngredientAdminDTO;

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

    @GetMapping("/categories/{id}")
    public CategoryDTO get(@PathVariable long id){
        return CategoryDTO.of(service.get(id));
    }

    @PostMapping("/categories")
    public CategoryDTO create(@RequestBody CategoryDTO dto){
        return CategoryDTO.of(service.create(dto.toCategory()));
    }
}
