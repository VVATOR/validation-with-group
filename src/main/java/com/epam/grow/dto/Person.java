package com.epam.grow.dto;

import com.epam.grow.annotation.validation.groups.GroupA;
import com.epam.grow.annotation.validation.groups.GroupB;
import javax.validation.constraints.NotNull;

public class Person {

  private String uid;

  @NotNull(groups = {GroupA.class})
  private String name;

  @NotNull(groups = {GroupB.class})
  private String middleName;

  @NotNull(groups = {GroupA.class, GroupB.class})
  private String lastName;

  public Person() {
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
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
}