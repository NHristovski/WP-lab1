package mk.ukim.finki.wp.lab1.validators;

import mk.ukim.finki.wp.lab1.model.Ingredient;
import mk.ukim.finki.wp.lab1.model.Pizza;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VeggiePizzaValidator implements ConstraintValidator<VeggiePizzaConstraint, Pizza> {
   public void initialize(VeggiePizzaConstraint constraint) {
   }

   public boolean isValid(Pizza pizza, ConstraintValidatorContext context) {
      if (pizza.getVeggie()){
         return pizza.getIngredients().stream().allMatch(Ingredient::isVeggie);
      }
      return true;
   }
}
