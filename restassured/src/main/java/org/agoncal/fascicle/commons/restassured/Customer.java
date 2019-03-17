package org.agoncal.fascicle.commons.restassured;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Customer {

  // ======================================
  // =             Attributes             =
  // ======================================

  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private LocalDate dateOfBirth;
  private Integer age;
  private LocalDateTime creationDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Customer() {
  }

  public Customer(UUID id) {
    this.id = id;
  }

  public Customer(UUID id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Customer(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, LocalDateTime creationDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.creationDate = creationDate;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Customer{" +
      "id='" + id + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      ", age=" + age +
      ", creationDate=" + creationDate +
      '}';
  }
}
