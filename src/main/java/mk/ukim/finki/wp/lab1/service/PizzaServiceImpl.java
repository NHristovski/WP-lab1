package mk.ukim.finki.wp.lab1.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Ingredient;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza addPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
        return pizza;
    }

    @Override
    public List<Pizza> getAllWithIngredient(Ingredient ingredient) {

        return pizzaRepository.findAll().stream().filter(p -> p.getIngredients().contains(ingredient)).collect(Collectors.toList());
    }

    @Override
    public Pizza editPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza deletePizza(Long id) {
        Pizza one = pizzaRepository.getOne(id);
        pizzaRepository.delete(one);
        return one;
    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getOne(Long id) {
        return pizzaRepository.getOne(id);
    }

    @Override
    public List<Pizza> getAllWithLessThan(int number) {
        return pizzaRepository.findAll().stream().filter(p -> p.getIngredients().size() < number).collect(Collectors.toList());
    }

    @Override
    public List<Ingredient> compare(Pizza p1, Pizza p2) {
        List<Ingredient> result = new ArrayList<>();

        for (Ingredient ing : p1.getIngredients()){
            if (p2.getIngredients().contains(ing)){
                result.add(ing);
            }
        }

        return result;
    }
}
