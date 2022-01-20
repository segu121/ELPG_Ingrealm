package vaaks.ingrealm.date.ingredients;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaaks.ingrealm.date.ingredients.dto.IngredientAdminDTO;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class IngredientController {

    private final IngredientService service;

//    @Autowired
//    public IngredientController(IngredientService service) {
//        this.service = service;
//    }

    @GetMapping("/ingredients")
    public List<IngredientAdminDTO> get(){
        return service.getAll().stream()
                .map(IngredientAdminDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/ingredients/{id}")
    public IngredientAdminDTO get(@PathVariable long id){
        return IngredientAdminDTO.of(service.get(id));
    }

    @PostMapping("/ingredients")
    public IngredientAdminDTO create(@RequestBody IngredientAdminDTO dto){
        return IngredientAdminDTO.of(service.create(dto.toIngredient()));
    }

    @PutMapping("/ingredients/{id}")
    public IngredientAdminDTO modify(@PathVariable long id, @RequestBody IngredientAdminDTO dto){
        Ingredient ingredient = service.update(id, dto.toIngredient());
        return IngredientAdminDTO.of(ingredient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/ingredients/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
