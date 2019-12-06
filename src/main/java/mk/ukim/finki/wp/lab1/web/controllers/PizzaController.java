package mk.ukim.finki.wp.lab1.web.controllers;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pizzas")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity addPizza(@RequestBody @Valid Pizza pizza) {
        return ResponseEntity.ok(pizzaService.addPizza(pizza));
    }

    @PutMapping("/{id}")
    public ResponseEntity editPizza(@PathVariable Long id,@RequestBody @Valid Pizza pizza) {
        return ResponseEntity.ok(pizzaService.editPizza(pizza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePizza(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaService.deletePizza(id));
    }

    @GetMapping
    public ResponseEntity getAll(@RequestParam(required = false) Integer totalIngredients) {
        if (totalIngredients == null) {
            return ResponseEntity.ok(pizzaService.getAll());
        } else {
            return ResponseEntity.ok(pizzaService.getAllWithLessThan(totalIngredients));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaService.getOne(id));
    }

    @GetMapping("/compare")
    public ResponseEntity compare(@RequestParam Long pizza1, @RequestParam Long pizza2) {

        Pizza firstPizza = pizzaService.getOne(pizza1);
        Pizza secondPizza = pizzaService.getOne(pizza2);

        return ResponseEntity.ok(pizzaService.compare(firstPizza, secondPizza));
    }
}
