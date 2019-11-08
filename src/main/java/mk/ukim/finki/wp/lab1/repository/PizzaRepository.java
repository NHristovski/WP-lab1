package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {

    List<Pizza> getPizzas();

    Optional<Pizza> getPizzaByName(String name);
}
