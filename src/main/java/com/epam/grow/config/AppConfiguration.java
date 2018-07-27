package com.epam.grow.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppConfiguration {
  @Bean
  public Validator validator() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    System.out.println();
    return validatorFactory.getValidator();
  }
}
