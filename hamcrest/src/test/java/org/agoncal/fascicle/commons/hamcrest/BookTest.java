package org.agoncal.fascicle.commons.hamcrest;

import org.junit.jupiter.api.Test;


// tag::adocSnippet[]
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BookTest {

  @Test
  public void shouldTestEquals() {
    Book oneBook = new Book("H2G2");
    Book anotherBook = new Book("H2G2");
    assertThat(oneBook, equalTo(anotherBook));
  }
}
// tag::adocSnippet[]
