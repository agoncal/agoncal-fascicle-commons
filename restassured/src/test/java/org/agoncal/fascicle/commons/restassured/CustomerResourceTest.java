package org.agoncal.fascicle.commons.restassured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocClass[]
// @formatter:off
public class CustomerResourceTest extends JerseyTest {

  private static RequestSpecification spec;

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerResource.class);
  }

  @BeforeAll
  public static void initSpec() {
    spec = new RequestSpecBuilder()
      .setBaseUri("http://localhost:9998/")
      .addFilter(new ResponseLoggingFilter())
      .addFilter(new RequestLoggingFilter())
      .build();
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

  @Test
  public void shouldListAllCustomersRestAssured() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers").
    then().
      statusCode(200).
      content("customer", hasItem("John"));
  }

  @Test
  public void shouldListAllCustomersRestAssuredAssertJ() {
    Customers customers =
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers").
    then().
      statusCode(200).
      extract().as(Customers.class);

    assertThat(customers.getCustomers()).
        extracting(customer -> customer.getFirstName()).
        contains("John");
  }

  @Test
  public void shouldGetCustomersRestAssured() {
    Customer customer =
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/1").
    then().
      statusCode(200).
      extract().as(Customer.class);

    assertThat(customer.getFirstName()).isEqualTo("John");
  }

  @Test
  public void shouldGetCustomersRestAssuredJSon() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/1").
    then().
      assertThat().
      body(equalTo("{\"firstName\":\"John\",\"id\":1,\"lastName\":\"Lennon\"}"));
  }

  @Test
  public void shouldGetCustomersRestAssuredJSonContains() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/1").
    then().
      assertThat().
      body(contains("John"));
  }

  @Test
  public void shouldGetCustomersRestAssuredJSonContainsContentJSon() {
    given().
      baseUri("http://localhost:9998").
      accept("application/json").
    when().
      get("/customers/1").
    then().
      statusCode(200);
  }

  @Test
  public void shouldGetCustomersRestAssuredJSonContainsContentXML() {
    given().
      baseUri("http://localhost:9998").
      accept("application/xml").
    when().
      get("/customers/1").
    then().
      statusCode(406);
  }

  @Test
  public void shouldCountCustomersRestAssured() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/count").
    then().
      statusCode(200);
  }

  @Test
  public void shouldCountCustomersRestAssuredBody() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/count").
    then().
      statusCode(200).
      body(containsString("4")).
      contentType(ContentType.TEXT);
  }
}
