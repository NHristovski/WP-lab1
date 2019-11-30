package mk.ukim.finki.wp.lab1.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = VeggiePizzaValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface VeggiePizzaConstraint {
    String message() default "Pizza is not veggie";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}