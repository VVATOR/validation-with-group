package com.epam.grow.annotation.validation.validators;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.epam.grow.annotation.validation.groups.GroupA;
import com.epam.grow.annotation.validation.groups.GroupB;
import com.epam.grow.dto.Field;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_1;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_2;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_3;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_4;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_5;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_6;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_7;


@RunWith(SpringJUnit4ClassRunner.class)
public class FieldsConstraintValidatorTest {

  private static final int VALID_COUNT_VIOLATION = 0;
  private static Validator validator;

  @BeforeClass
  public static void setUp() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @Test
  public void testValidator_emptyObject_without_group() {
    Field person = new Field();
    Set<ConstraintViolation<Field>> violations = validator.validate(person);
    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_valid_without_group() {
    Field person = buildValidField();
    Set<ConstraintViolation<Field>> violations = validator.validate(person);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_invalid_without_group() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(3, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_1));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_2));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  @Test
  public void testValidator_emptyObject_with_Default() {
    Field person = new Field();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, Default.class);
    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_valid_with_Default() {
    Field person = buildValidField();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, Default.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_invalid_with_Default() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, Default.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(3, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_1));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_2));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  @Test
  public void testValidator_emptyObject_with_GroupB() {
    Field person = new Field();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupB.class);
    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_valid_with_GroupB() {
    Field person = buildValidField();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_invalid_with_GroupB() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(4, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_4));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_5));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_6));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  @Test
  public void testValidator_emptyObject_with_multigroup_GroupA_GroupB() {
    Field person = new Field();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class, GroupB.class);
    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_valid_with_multigroup_GroupA_GroupB() {
    Field person = buildValidField();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_invalid_with_multigroup_GroupA_GroupB() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(5, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_3));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_4));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_5));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_6));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  @Test
  public void testValidator_invalid_with_multigroup_Default_GroupA_GroupB() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, Default.class, GroupA.class, GroupB.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(7, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_1));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_2));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_3));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_4));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_5));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_6));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  @Test
  public void testValidator_emptyObject_with_GroupA() {
    Field person = new Field();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class);
    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_valid_with_GroupA() {
    Field person = buildValidField();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(VALID_COUNT_VIOLATION, violations.size());
  }

  @Test
  public void testValidator_invalid_with_GroupA() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(4, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_3));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_5));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_6));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }

  @Test
  public void testValidator_invalid_with_ALL_GROUP() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, GroupA.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(4, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_3));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_5));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_6));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  @Test
  public void testValidator_invalid_with_multigroup_Default_and_GroupA_IMPORTANT() {
    Field person = buildFieldWithInvalidValues();
    Set<ConstraintViolation<Field>> violations = validator.validate(person, Default.class, GroupA.class);
    String concatViolations = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));

    assertEquals(6, violations.size());
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_1));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_2));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_3));
    // assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_4)); //not used because field define ONLY groups = {GroupB.class}
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_5));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_6));
    assertThat(concatViolations, containsString(CONSTRAINT_MESSAGE_FOR_FIELD_7));
  }


  private Field buildValidField() {
    Field field = new Field();
    field.setField_1(CONSTRAINT_MESSAGE_FOR_FIELD_1);
    field.setField_2(CONSTRAINT_MESSAGE_FOR_FIELD_2);
    field.setField_3(CONSTRAINT_MESSAGE_FOR_FIELD_3);
    field.setField_4(CONSTRAINT_MESSAGE_FOR_FIELD_4);
    field.setField_5(CONSTRAINT_MESSAGE_FOR_FIELD_5);
    field.setField_6(CONSTRAINT_MESSAGE_FOR_FIELD_6);
    field.setField_7(CONSTRAINT_MESSAGE_FOR_FIELD_7);
    return field;
  }

  private Field buildFieldWithInvalidValues() {
    Field field = new Field();
    field.setField_1("Field_1__________________");
    field.setField_2("Field_2__________________");
    field.setField_3("Field_3__________________");
    field.setField_4("Field_4__________________");
    field.setField_5("Field_5__________________");
    field.setField_6("Field_6__________________");
    field.setField_7("Field_7__________________");
    return field;
  }

}