package com.epam.grow.config;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class AppConfiguration {

  @Bean
  public Validator validator() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    return validatorFactory.getValidator();
  }

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.epam.grow"))
        .paths(regex("/*"))
        .build()
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfo(
        "Spring Boot REST API",
        "Spring Boot REST API for Online Store",
        "1.0",
        "Terms of service",
        new Contact("VItali Vikhliayeu", "", "vvator@gmail.com"),
        "Apache License Version 2.0",
        "https://www.apache.org/licenses/LICENSE-2.0");

  }
}
