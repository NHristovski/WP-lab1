package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Ingredient;
import mk.ukim.finki.wp.lab1.model.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza addPizza(Pizza pizza);

    List<Pizza> getAllWithIngredient(Ingredient ingredient);

    Pizza editPizza(Pizza pizza);

    Pizza deletePizza(Long id);

    List<Pizza> getAll();

    Pizza getOne(Long id);

    List<Pizza> getAllWithLessThan(int number);

    List<Ingredient> compare(Pizza p1,Pizza p2);
}
