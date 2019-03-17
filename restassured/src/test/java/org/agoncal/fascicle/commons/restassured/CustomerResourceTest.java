package org.agoncal.fascicle.commons.restassured;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @BeforeEach
  public void before() throws Exception {
    super.setUp();
  }

  @AfterEach
  public void after() throws Exception {
    super.tearDown();
  }

  @Test
  public void shouldListAllCustomers() {
    Response response = target("/customers").request().get();
    Assertions.assertEquals(200, response.getStatus(), "should return status 200");
    Customers customers = response.readEntity(Customers.class);
    assertEquals(new Integer(4), new Integer(customers.size()));
  }

  @Test
  public void shouldCountCustomers() {
    Response response = target("/customers/count").request(MediaType.TEXT_PLAIN).get();
    Assertions.assertEquals(200, response.getStatus(), "should return status 200");
    Integer nbOfCustomers = response.readEntity(Integer.class);
    assertEquals(new Integer(4), nbOfCustomers);
  }

}
