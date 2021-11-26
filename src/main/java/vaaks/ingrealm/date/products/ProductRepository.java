package vaaks.ingrealm.date.products;

import org.springframework.data.jpa.repository.JpaRepository;
import vaaks.ingrealm.date.products.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
