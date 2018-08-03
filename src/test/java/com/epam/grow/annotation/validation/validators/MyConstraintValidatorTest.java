package com.epam.grow.annotation.validation.validators;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import com.epam.grow.annotation.validation.groups.GroupA;
import com.epam.grow.annotation.validation.groups.GroupB;
import com.epam.grow.dto.Person;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class MyConstraintValidatorTest {

  private static Validator validator;

  @BeforeClass
  public static void setUp() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @Test
  public void testValidator() {
    Person person = new Person();
    Set<ConstraintViolation<Person>> violations = validator.validate(person);
    assertEquals(0, violations.size());
  }


  @Test
  public void testValidatorWithGroupDefault() {
    Person person = buildPerson();
    Set<ConstraintViolation<Person>> violations = validator.validate(person);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
    assertEquals(2, violations.size());
    assertThat(concatViolations, containsString("Field uid is short"));
    assertThat(concatViolations, containsString("Field age is short"));
  }

  @Test
  public void testValidatorWithGroup_GroupA() {
    Person person = buildPerson();
    Set<ConstraintViolation<Person>> violations = validator.validate(person, GroupA.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(2, violations.size());
    assertNotEquals("",
        "Costraint violations: " + concatViolations);

    assertThat(concatViolations, containsString("Field name is short"));
    assertThat(concatViolations, containsString("Field lastName is short"));
  }

  @Test
  public void testValidatorWithGroup_GroupB() {
    Person person = buildPerson();
    Set<ConstraintViolation<Person>> violations = validator.validate(person, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(2, violations.size());
    assertNotEquals("",
        "Costraint violations: " + concatViolations);

    assertThat(concatViolations, containsString("Field name is short"));
    assertThat(concatViolations, containsString("Field lastName is short"));
  }

  @Test
  public void testValidatorWith_MultiGroup() {
    Person person = buildPerson();
    Set<ConstraintViolation<Person>> violations =  validator.validate(person, GroupA.class, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(2, violations.size());
    assertEquals("",
        "Costraint violations: " + concatViolations);
    /*assertThat(concatViolations, containsString("Field name is short"));
    assertThat(concatViolations, containsString("Field middleName is short"));
    assertThat(concatViolations, containsString("Field lastName is short"));*/
  }


  private Person buildPerson() {
    Person person = new Person();
    person.setUid("uid");
    person.setAge("age");
    person.setName("name");
    person.setMiddleName("middleName");
    person.setLastName("lastName");
    return person;
  }

}