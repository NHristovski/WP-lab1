package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface CustomPizzaRepository {

    List<Pizza> getPizzas();

    Optional<Pizza> getPizzaByName(String name);

    void addPizza(Pizza pizza);
}
