package com.epam.grow.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
  @Bean
  public Validator validator() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    return validatorFactory.getValidator();
  }
}
