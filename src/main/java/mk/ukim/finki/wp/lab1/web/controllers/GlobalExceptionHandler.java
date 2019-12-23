package mk.ukim.finki.wp.lab1.web.controllers;

import mk.ukim.finki.wp.lab1.service.exceptions.DuplicateIngredientException;
import mk.ukim.finki.wp.lab1.service.exceptions.IngredientNotFoundException;
import mk.ukim.finki.wp.lab1.service.exceptions.SpicyIngredientsLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateIngredientException.class)
    public ResponseEntity handleDuplicateIngredientException(DuplicateIngredientException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(SpicyIngredientsLimitReachedException.class)
    public ResponseEntity handleSpicyIngredientsLimitReachedException(SpicyIngredientsLimitReachedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public ResponseEntity handleIngredientNotFoundException(IngredientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
