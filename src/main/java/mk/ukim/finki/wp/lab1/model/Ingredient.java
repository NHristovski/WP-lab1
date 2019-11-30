package mk.ukim.finki.wp.lab1.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;

    private boolean spicy;
    private float amount;
    private boolean veggie;

    public Ingredient(String name,Boolean spicy,Float amount,Boolean veggie){
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
    }
}
