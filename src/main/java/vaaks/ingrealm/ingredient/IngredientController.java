package vaaks.ingrealm.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientController {

    private final IngredientService service;

    @Autowired
    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @GetMapping("/ingredients")
    public List<IngredientDTO> get(){
        return service.getAll().stream()
                .map(IngredientDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/ingredients/{id}")
    public IngredientDTO get(@PathVariable long id){
        return IngredientDTO.of(service.get(id));
    }

    @PostMapping("/ingredients")
    public IngredientDTO create(@RequestBody IngredientDTO dto){
        return IngredientDTO.of(service.create(dto.toIngredient()));
    }

    @PutMapping("/ingredients/{id}")
    public IngredientDTO modify(@PathVariable long id, @RequestBody IngredientDTO dto){
        Ingredient ingredient = service.update(id, dto.toIngredient());
        return IngredientDTO.of(ingredient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/ingredients/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
