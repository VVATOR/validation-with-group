package com.epam.grow.controllers;


import com.epam.grow.annotation.validation.groups.GroupB;
import com.epam.grow.dto.Person;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ValidationController {

  private static final Logger LOG = LoggerFactory.getLogger(ValidationController.class);

  @Autowired
  private Validator validator;

  public void setValidator(Validator validator) {
    this.validator = validator;
  }

  @RequestMapping(value = "/custom/1",
      method = RequestMethod.POST,
      consumes = {"application/json"},
      produces = {"application/json"}
  )
  public ResponseEntity validCase_custom1(@RequestBody Person person) {
    LOG.info("====>{}", person);
    Set<ConstraintViolation<Person>> violations = validator.validate(person, GroupB.class);
    if (!violations.isEmpty()) {
      throw new RuntimeException("" + violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("; ")));
    }

    return new ResponseEntity<String>("Hello World", null, HttpStatus.OK);
  }

  @RequestMapping(value = "/valid/1", method = RequestMethod.POST)
  public void validCase1(@RequestBody Person person) {
    validator.validate(person);
    LOG.info("validCase1: " + validator.validate(person));
  }

  @RequestMapping(value = "/valid/2", method = RequestMethod.POST)
  public void validCase2(@RequestBody Person person) {
    validator.validate(person);
    LOG.info("validCase1: " + validator.validate(person));
  }

  @RequestMapping(value = "/valid/3", method = RequestMethod.POST)
  public void validCase3(@RequestBody @Validated Person person) {
    validator.validate(person);
    LOG.info("validCase3: " + validator.validate(person));
  }


}
