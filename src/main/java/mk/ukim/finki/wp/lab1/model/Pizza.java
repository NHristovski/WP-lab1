package mk.ukim.finki.wp.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab1.validators.VeggiePizzaConstraint;

import javax.persistence.*;
import javax.swing.table.TableModel;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@VeggiePizzaConstraint
public class Pizza {

    public Pizza(String name,String description, Boolean veggie,List<Ingredient> ingredients){
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Boolean veggie;
    @ManyToMany(cascade = {
            CascadeType.DETACH
    },fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;
}
