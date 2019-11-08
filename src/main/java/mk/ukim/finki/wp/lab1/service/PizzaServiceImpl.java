package mk.ukim.finki.wp.lab1.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> listPizzas() {
        return pizzaRepository.getPizzas()  ;
    }

    @Override
    public Optional<Pizza> getPizzaByName(String name) {
        return pizzaRepository.getPizzaByName(name);
    }
}
