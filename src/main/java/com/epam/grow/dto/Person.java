package com.epam.grow.dto;

import com.epam.grow.annotation.validation.constrasints.NotShortThan10Constraint;
import com.epam.grow.annotation.validation.groups.GroupA;
import com.epam.grow.annotation.validation.groups.GroupB;
import javax.validation.groups.Default;

public class Person {

  private String id;

  @NotShortThan10Constraint(
      message = "Field uid is short"
  )
  private String uid;

  @NotShortThan10Constraint(
      groups = Default.class,
      message = "Field age is short"
  )
  private String age;

  @NotShortThan10Constraint(
      groups = {GroupA.class},
      message = "Field name is short"
  )
  private String name;

  @NotShortThan10Constraint(
      groups = {GroupB.class},
      message = "Field middleName is short"
  )
  private String middleName;

  @NotShortThan10Constraint(
      groups = {GroupB.class, GroupA.class},
      message = "Field lastName is short")
  private String lastName;

  public Person() {
    super();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("id='").append(id).append('\'');
    sb.append(", uid='").append(uid).append('\'');
    sb.append(", age='").append(age).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", middleName='").append(middleName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}