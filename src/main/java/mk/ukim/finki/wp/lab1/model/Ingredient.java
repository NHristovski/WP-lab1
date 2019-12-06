package mk.ukim.finki.wp.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@Entity
@Table(name = "ingredients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
        System.out.println("ctor called: " + name + " ; " + spicy + " : " + amount  +" ; " + veggie);
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
    }
}
