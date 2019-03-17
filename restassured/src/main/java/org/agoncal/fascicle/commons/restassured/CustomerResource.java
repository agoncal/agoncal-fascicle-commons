package org.agoncal.fascicle.commons.restassured;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/customers")
public class CustomerResource {

  private static Customers customers = new Customers();

  static {
    customers.addAll(Arrays.asList(
      new Customer(UUID.randomUUID(), "John", "Lennon"),
      new Customer(UUID.randomUUID(), "Paul", "McCartney"),
      new Customer(UUID.randomUUID(), "George", "Harrison"),
      new Customer(UUID.randomUUID(), "Ringo", "Starr")
    ));
  }

  @POST
  public Response createArtist(@Context UriInfo uriInfo, Customer customer) {
    customer.setId(UUID.randomUUID());
    customers.add(customer);
    URI uri = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();
    return Response.created(uri).build();
  }

  @GET
  public Response getAllCustomers() {
    return Response.ok(customers).build();
  }

  @GET
  @Path("/{id}")
  public Response getCustomer(@PathParam("id") UUID id) {
    Customer customer = customers.stream()
      .filter(a -> id.equals(a.getId()))
      .findFirst()
      .orElse(null);
    return Response.ok(customer).build();
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public Integer countCustomers() {
    return customers.size();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteCustomer(@PathParam("id") UUID id) {
    customers.removeIf(x -> customers.contains(new Customer(id)));
    return Response.noContent().build();
  }
}
// end::adocsnippet[]
