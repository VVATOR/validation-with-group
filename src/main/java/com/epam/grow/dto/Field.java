package com.epam.grow.dto;

import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_1;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_2;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_3;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_4;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_5;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_6;
import static com.epam.grow.config.Constants.CONSTRAINT_MESSAGE_FOR_FIELD_7;

import com.epam.grow.annotation.validation.constrasints.LessThan20Constraint;
import com.epam.grow.annotation.validation.groups.GroupA;
import com.epam.grow.annotation.validation.groups.GroupB;
import javax.validation.groups.Default;

public class Field {

  // Unchecked with validators
  private String id;

  @LessThan20Constraint(
      message = CONSTRAINT_MESSAGE_FOR_FIELD_1
  )
  private String field_1;

  @LessThan20Constraint(
      groups = Default.class,
      message = CONSTRAINT_MESSAGE_FOR_FIELD_2
  )
  private String field_2;

  @LessThan20Constraint(
      groups = {GroupA.class},
      message = CONSTRAINT_MESSAGE_FOR_FIELD_3
  )
  private String field_3;

  @LessThan20Constraint(
      groups = {GroupB.class},
      message = CONSTRAINT_MESSAGE_FOR_FIELD_4
  )
  private String field_4;

  @LessThan20Constraint(
      groups = {GroupB.class, GroupA.class},
      message = CONSTRAINT_MESSAGE_FOR_FIELD_5)
  private String field_5;

  @LessThan20Constraint(
      groups = {GroupA.class, GroupB.class},
      message = CONSTRAINT_MESSAGE_FOR_FIELD_6)
  private String field_6;

  @LessThan20Constraint(
      groups = {Default.class, GroupA.class, GroupB.class},
      message = CONSTRAINT_MESSAGE_FOR_FIELD_7)
  private String field_7;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getField_1() {
    return field_1;
  }

  public void setField_1(String field_1) {
    this.field_1 = field_1;
  }

  public String getField_2() {
    return field_2;
  }

  public void setField_2(String field_2) {
    this.field_2 = field_2;
  }

  public String getField_3() {
    return field_3;
  }

  public void setField_3(String field_3) {
    this.field_3 = field_3;
  }

  public String getField_4() {
    return field_4;
  }

  public void setField_4(String field_4) {
    this.field_4 = field_4;
  }

  public String getField_5() {
    return field_5;
  }

  public void setField_5(String field_5) {
    this.field_5 = field_5;
  }

  public String getField_6() {
    return field_6;
  }

  public void setField_6(String field_6) {
    this.field_6 = field_6;
  }

  public String getField_7() {
    return field_7;
  }

  public void setField_7(String field_7) {
    this.field_7 = field_7;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Field{");
    sb.append("id='").append(id).append('\'');
    sb.append(", field_1='").append(field_1).append('\'');
    sb.append(", field_2='").append(field_2).append('\'');
    sb.append(", field_3='").append(field_3).append('\'');
    sb.append(", field_4='").append(field_4).append('\'');
    sb.append(", field_5='").append(field_5).append('\'');
    sb.append(", field_6='").append(field_6).append('\'');
    sb.append(", field_7='").append(field_7).append('\'');
    sb.append('}');
    return sb.toString();
  }
}