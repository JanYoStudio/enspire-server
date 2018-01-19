package pw.janyo.enspire.constraint;

import pw.janyo.enspire.EnspireGlobals;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {Username.Validator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface Username {

    int min() default 1;

    int max() default EnspireGlobals.SIZE_USERNAME;

    String message() default "{org.hibernate.validator.constraints.Length.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<Username, String> {
        private int min;
        private int max;

        public void initialize(final Username annotation) {
            this.min = annotation.min();
            this.max = annotation.max();
        }

        public boolean isValid(final String value, final ConstraintValidatorContext context) {
            return value == null || (value.length() >= min && value.length() <= max);
        }
    }
}