package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    List<Pizza> listPizzas();
    Optional<Pizza> getPizzaByName(String name);
}
