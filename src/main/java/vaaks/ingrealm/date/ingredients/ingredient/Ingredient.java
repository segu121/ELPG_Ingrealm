package vaaks.ingrealm.date.ingredients.ingredient;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "ingredients")
//@Table(name = "ingredients")
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
//    @Column(name = "inci_name")
    private String INCI_Name;
//    private long categoryId;
    private int rating;
}
