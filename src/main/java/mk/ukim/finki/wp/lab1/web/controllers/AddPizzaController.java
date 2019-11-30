package mk.ukim.finki.wp.lab1.web.controllers;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.service.PizzaServiceOld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class AddPizzaController {

    private final PizzaServiceOld pizzaServiceOld;

    @PostMapping("add/pizza")
    public String addPizza(@RequestParam String pizzaName, @RequestParam String pizzaDesc, Model model){

        System.out.println("PN: " + pizzaName + " PD: " + pizzaDesc);
        Pizza pizza = new Pizza(pizzaName,pizzaDesc,true,new ArrayList<>());

        pizzaServiceOld.addPizza(pizza);

        model.addAttribute("pizzas", pizzaServiceOld.listPizzas());
        return "listPizzas";
    }
}
