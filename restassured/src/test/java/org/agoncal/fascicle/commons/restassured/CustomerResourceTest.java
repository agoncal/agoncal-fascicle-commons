package org.agoncal.fascicle.commons.restassured;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocClass[]
public class CustomerResourceTest extends JerseyTest {

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerResource.class);
  }

// tag::adocFixture[]
//  @BeforeEach
//  public void clearCustomer() {
//  }
// end::adocFixture[]

  // tag::ageShouldBeGreaterThanZero[]
//  @Test
//  public void ageShouldBeGreaterThanZero() {
//  }
// end::ageShouldBeGreaterThanZero[]

    @Test
  public void shouldListAllArtists() {
    Response response = target("/users").request().get();
    Assertions.assertEquals(200, response.getStatus(), "should return status 200");
    assertNotNull("Should return user list", response.getEntity().toString());
  }

}
