package vaaks.ingrealm.date.ingredients.ingredient;

import lombok.*;
import vaaks.ingrealm.date.category.Category;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity//(name = "ingredients")
@Table(name = "ingredients")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int naturalRating;
    private String description;
    @Column(name = "inci_name")
    private String INCIName;

    @ManyToMany
    @JoinTable(
            name = "ingredient_category",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
    private int rating;
}
