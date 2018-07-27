package com.epam.grow.controllers;


import com.epam.grow.dto.Person;
import javax.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ValidationController {

  private static final Logger LOG = LoggerFactory.getLogger(ValidationController.class);

  @Autowired
  Validator validator;

  @RequestMapping(value = "/valid/1", method = RequestMethod.POST)
  public void validCase1(@RequestBody Person person) {
    validator.validate(person);
    System.out.println("validCase1: " + validator.validate(person));
  }

  @RequestMapping(value = "/valid/3", method = RequestMethod.POST)
  public void validCase2(@RequestBody @Validated Person person) {
    validator.validate(person);
    LOG.info("validCase3: " + validator.validate(person));
  }


}
