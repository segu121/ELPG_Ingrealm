package vaaks.ingrealm.date.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaaks.ingrealm.date.ingredients.ingredient.Ingredient;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category get(long id) {
        return repository.findById(id).orElseThrow();
    }

    public Category create(Category category) {
        return repository.save(category);
    }
}
