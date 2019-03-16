package org.agoncal.fascicle.commons.restassured;

import org.agoncal.fascicle.commons.restassured.CustomerResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocClass[]
public class CustomerResourceTest {

  private CustomerResource customer = new CustomerResource();

// end::adocClass[]

// tag::adocFixture[]
  @BeforeEach
  public void clearCustomer() {
  }
// end::adocFixture[]

// tag::ageShouldBeGreaterThanZero[]
  @Test
  public void ageShouldBeGreaterThanZero() {
  }
// end::ageShouldBeGreaterThanZero[]

}
