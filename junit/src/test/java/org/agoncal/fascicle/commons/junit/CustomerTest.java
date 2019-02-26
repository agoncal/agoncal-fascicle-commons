package org.agoncal.fascicle.commons.junit;

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
public class CustomerTest {

  private Customer customer = new Customer();

  @BeforeEach
  public void clearCustomer() {
    customer.clear();
  }

  @Test
  public void ageShouldBeGretaterThanZero() {
    customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com");
    customer.setDateOfBirth(LocalDate.of(1975, 5, 27));

    customer.calculateAge();

    assertTrue(customer.getAge() >= 0);
  }

//  @Test
//  public void ageShouldBe42() {
//    int expectedAge = 42;
//    Calendar birth = new GregorianCalendar();
//    birth.roll(Calendar.YEAR, expectedAge * (-1));
//    birth.roll(Calendar.DAY_OF_YEAR, -1);
//
//    customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com");
//    customer.setDateOfBirth(birth.getTime());
//
//    customer.calculateAge();
//    assertEquals(new Long(expectedAge), new Long(customer.getAge()));
//  }

  @Test
  public void shouldThrowAnExceptionCauseDateOfBirtheIsNull() {

    // tag::shouldThrowAnExceptionCauseDateOfBirtheIsNull[]
    customer = null;
    assertThrows(NullPointerException.class, () -> {
      customer.calculateAge();
    });
    // end::shouldRaiseConstraintViolationCauseNullTitle[]
  }

  @Test
  @Disabled("Test is not ready yet")
  public void shouldCalculateOldAge() {
    // some work to do
  }
}
