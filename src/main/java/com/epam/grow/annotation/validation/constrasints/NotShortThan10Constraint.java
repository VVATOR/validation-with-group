package com.epam.grow.annotation.validation.constrasints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.epam.grow.annotation.validation.validators.NotShortThan10Validator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NotShortThan10Validator.class)
public @interface NotShortThan10Constraint {

  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
