package mk.ukim.finki.wp.lab1.repository;

import lombok.Getter;
import mk.ukim.finki.wp.lab1.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Repository
public class InMemoryCustomPizzaRepositoryImpl implements CustomPizzaRepository {
    private List<Pizza> pizzas;

    public InMemoryCustomPizzaRepositoryImpl(){
        pizzas = new ArrayList<>(10);

//        pizzas.add(new Pizza("Pizza1","Description1"));
//        pizzas.add(new Pizza("Pizza2","Description2"));
//        pizzas.add(new Pizza("Pizza3","Description3"));
//        pizzas.add(new Pizza("Pizza4","Description4"));
//        pizzas.add(new Pizza("Pizza5","Description5"));
//        pizzas.add(new Pizza("Pizza6","Description6"));
//        pizzas.add(new Pizza("Pizza7","Description7"));
//        pizzas.add(new Pizza("Pizza8","Description8"));
//        pizzas.add(new Pizza("Pizza9","Description9"));
//        pizzas.add(new Pizza("Pizza10","Description10"));
    }


    @Override
    public Optional<Pizza> getPizzaByName(String name) {
        return pizzas.stream()
                .filter(pizza -> pizza.getName().equals(name))
                .findFirst();
    }

    @Override
    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}
