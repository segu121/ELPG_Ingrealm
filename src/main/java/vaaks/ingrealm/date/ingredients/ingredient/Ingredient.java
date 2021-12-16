package vaaks.ingrealm.date.ingredients.ingredient;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
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
    private String INCIName;
//    private long categoryId;
    private int rating;
}
