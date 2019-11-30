package mk.ukim.finki.wp.lab1.service.exceptions;

import mk.ukim.finki.wp.lab1.model.Ingredient;

public class IngredientNotFoundException extends Exception {
    public IngredientNotFoundException(String msg){
        super(msg);
    }
}
