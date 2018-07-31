package com.epam.grow.dto;

import com.epam.grow.annotation.validation.constrasints.MyConstraint;
import com.epam.grow.annotation.validation.groups.GroupA;
import com.epam.grow.annotation.validation.groups.GroupB;

public class Person {

  private String uid;

  @MyConstraint(
      message = "Field age is short"
  )
  private String age;

  @MyConstraint(
      groups = {GroupA.class},
      message = "Field name is short"
  )
  private String name;

  @MyConstraint(
      groups = {GroupB.class},
      message = "Field middleName is short"
  )
  private String middleName;

  @MyConstraint(
      groups = {GroupA.class, GroupB.class},
      message = "Field lastName is short")
  private String lastName;

  public Person() {
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
    final StringBuffer sb = new StringBuffer("Person{");
    sb.append("uid='").append(uid).append('\'');
    sb.append(", age='").append(age).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", middleName='").append(middleName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}