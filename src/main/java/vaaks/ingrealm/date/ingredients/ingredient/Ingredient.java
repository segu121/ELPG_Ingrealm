package vaaks.ingrealm.date.ingredients.ingredient;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int naturalRating;
    private String description;
    private String INCIName;
    private long categoryId;
    private int rating;
}
