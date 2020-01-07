package org.agoncal.fascicle.commons.restassured;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
@QuarkusTest
public class CustomerResourceTest {

  @Test
  public void shouldListAllCustomers() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers").
    then().
      statusCode(200);
//      content("customer", hasItem("John"));
  }

  @Test
  public void shouldGetCustomers() {
    Customer customer =
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/1").
    then().
      statusCode(200).
      extract().as(Customer.class);

    //assertThat(customer.getFirstName()).isEqualTo("John");
  }

  @Test
  public void shouldGetCustomersJSon() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/1").
    then().
      assertThat().
      body(equalTo("{\"firstName\":\"John\",\"id\":1,\"lastName\":\"Lennon\"}"));
  }

  @Test
  public void shouldGetCustomersJSonContains() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/1").
    then().
      assertThat().
      body(contains("John"));
  }

  @Test
  public void shouldGetCustomersJSonContainsContentJSon() {
    given().
      baseUri("http://localhost:9998").
      accept("application/json").
    when().
      get("/customers/1").
    then().
      statusCode(200);
  }

  @Test
  public void shouldGetCustomersJSonContainsContentXML() {
    given().
      baseUri("http://localhost:9998").
      accept("application/xml").
    when().
      get("/customers/1").
    then().
      statusCode(406);
  }

  @Test
  public void shouldCountCustomers() {
    given().
      baseUri("http://localhost:9998").
    when().
      get("/customers/count").
    then().
      statusCode(200);
  }

  @Test
  public void shouldCountCustomersBody() {
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
