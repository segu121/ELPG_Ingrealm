package vaaks.ingrealm.date.ingredients.ingredient;

import lombok.*;
import vaaks.ingrealm.date.category.Category;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<Category> categories;
    private int rating;
}
