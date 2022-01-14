package vaaks.ingrealm.date.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaaks.ingrealm.date.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
