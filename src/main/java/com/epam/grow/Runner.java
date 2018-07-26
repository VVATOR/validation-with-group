package com.epam.grow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.epam.grow"})
public class Runner {

  public static void main(String[] args) {
    SpringApplication.run(Runner.class, args);
  }

}