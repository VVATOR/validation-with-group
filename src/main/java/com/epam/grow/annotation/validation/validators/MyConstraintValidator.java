package com.epam.grow.annotation.validation.validators;

import static java.util.Objects.isNull;

import com.epam.grow.annotation.validation.constrasints.MyConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {

  private String message;

  @Override
  public void initialize(MyConstraint constraintAnnotation) {
    this.message = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(String str, ConstraintValidatorContext context) {
    if (isNull(str) || str.isEmpty()) {
      return true;
    }
    if (str.length() < 10) {
      buildConstraintValidatorContext(message, "node", context);
      return false;
    }
    return true;
  }

  private void buildConstraintValidatorContext(String message, String propertyNode, ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate(message)
        .addPropertyNode(propertyNode)
        .addConstraintViolation()
        .disableDefaultConstraintViolation();
  }
}
