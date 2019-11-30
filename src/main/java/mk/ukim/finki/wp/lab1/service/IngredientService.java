package mk.ukim.finki.wp.lab1.service;


import mk.ukim.finki.wp.lab1.model.Ingredient;
import mk.ukim.finki.wp.lab1.service.exceptions.DuplicateIngredientException;
import mk.ukim.finki.wp.lab1.service.exceptions.IngredientNotFoundException;
import mk.ukim.finki.wp.lab1.service.exceptions.SpicyIngredientsLimitReachedException;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

public interface IngredientService {
    Ingredient add(Ingredient ingredient) throws DuplicateIngredientException, SpicyIngredientsLimitReachedException;
    Ingredient edit(Ingredient ingredient) throws DuplicateIngredientException, SpicyIngredientsLimitReachedException, IngredientNotFoundException;
    Ingredient delete(Long id);
    Ingredient getOne(Long id);
    List<Ingredient> getAll(int currentPage,int pageSize);
    List<Ingredient> getAll();
    List<Ingredient> getAllSpicy();
//    Pageable sortedByName =
//            PageRequest.of(0, 3, Sort.by("name"));
}
