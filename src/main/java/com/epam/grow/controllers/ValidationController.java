package com.epam.grow.controllers;


import com.epam.grow.dto.Person;

import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ValidationController {

  @Autowired
  Validator validator;

  @RequestMapping(value = "/valid/1", method = RequestMethod.POST)
  public void validCase1(@RequestBody Person person){

  }


}
