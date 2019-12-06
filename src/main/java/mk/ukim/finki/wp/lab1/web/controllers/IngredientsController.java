package mk.ukim.finki.wp.lab1.web.controllers;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Ingredient;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.service.IngredientService;
import mk.ukim.finki.wp.lab1.service.PizzaService;
import mk.ukim.finki.wp.lab1.service.exceptions.DuplicateIngredientException;
import mk.ukim.finki.wp.lab1.service.exceptions.IngredientNotFoundException;
import mk.ukim.finki.wp.lab1.service.exceptions.SpicyIngredientsLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IngredientsController {

    private final IngredientService ingredientService;
    private final PizzaService pizzaService;

    @PostMapping("/ingredients")
    public ResponseEntity addIngredient(@RequestBody Ingredient ingredient) {
        System.out.println("ingredient: " + ingredient.toString());
        try {
            ingredientService.add(ingredient);
            return ResponseEntity.status(HttpStatus.CREATED).body(ingredient);

        } catch (DuplicateIngredientException | SpicyIngredientsLimitReachedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/ingredients/{id}")
    public ResponseEntity editIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        try {
            System.out.println("ing: " + ingredient.toString());
            ingredientService.edit(ingredient);
            return ResponseEntity.ok(ingredient);

        } catch (DuplicateIngredientException | SpicyIngredientsLimitReachedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (IngredientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ingredientService.delete(id));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id) {
        try {
            Ingredient ingredient = ingredientService.getOne(id);
            return ResponseEntity.ok(ingredient);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ingredients")
    public ResponseEntity getIngredients(@RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "5") Integer size,
                                         @RequestParam(required = false) Boolean spicy) {

        if (spicy != null) {
            System.out.println("spicy not null");
            if (spicy) {
                return ResponseEntity.ok(ingredientService.getAllSpicy());
            } else {
                List<Ingredient> all = ingredientService.getAll();
                List<Ingredient> allSpicy = ingredientService.getAllSpicy();

                all.removeAll(allSpicy);

                return ResponseEntity.ok(all);
            }
        }

        if (size > 10) {
            size = 10;
        }
        System.out.println("spicy null");
        return ResponseEntity.ok(ingredientService.getAll(page, size));
    }


    @GetMapping("/ingredients/{id}/pizzas")
    public ResponseEntity getAllPizzas(@PathVariable Long id) {
        List<Pizza> allWithIngredient = pizzaService.getAllWithIngredient(ingredientService.getOne(id));
        return ResponseEntity.ok(allWithIngredient);
    }

}
