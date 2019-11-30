package mk.ukim.finki.wp.lab1.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.repository.CustomPizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PizzaServiceOldImpl implements PizzaServiceOld {

    private final CustomPizzaRepository customPizzaRepository;

    @Override
    public List<Pizza> listPizzas() {
        return customPizzaRepository.getPizzas()  ;
    }

    @Override
    public Optional<Pizza> getPizzaByName(String name) {
        return customPizzaRepository.getPizzaByName(name);
    }

    @Override
    public void addPizza(Pizza p) {
        this.customPizzaRepository.addPizza(p);
    }
}
