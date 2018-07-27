package com.epam.grow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication(scanBasePackages = {"com.epam.grow"})
public class Runner {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Runner.class, args);
  }


}