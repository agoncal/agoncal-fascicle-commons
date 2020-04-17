package org.agoncal.fascicle.commons.hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BookAssertionsTest {

  @Test
  public void shouldAssertThat() {
    Book book = new Book("H2G2", 1979);
    Book anotherBook = new Book("H2G2", 1979);
    // tag::adocAssertThat[]
    assertThat(book.getTitle(), equalTo("H2G2"));
    assertThat(book.getYearOfPublication(), equalTo(1979));
    assertThat(book, equalTo(anotherBook));
    // end::adocAssertThat[]
  }

  @Test
  public void shouldAssertThatIs() {
    Book book = new Book("H2G2", 1979);
    Book anotherBook = new Book("H2G2", 1979);
    // tag::adocAssertThatIs[]
    assertThat(book.getTitle(), is(equalTo("H2G2")));
    assertThat(book.getYearOfPublication(), is(equalTo(1979)));
    assertThat(book, is(anotherBook));
    // end::adocAssertThat[]
  }
}
