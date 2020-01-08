package org.agoncal.fascicle.commons.restassured;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customers extends ArrayList<Customer> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public List<Customer> getCustomers() {
    return this;
  }
}
