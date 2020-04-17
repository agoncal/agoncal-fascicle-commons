package org.agoncal.fascicle.commons.hamcrest;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;

public class Book {

  public String title;
  public String isbn13;
  public String isbn10;
  public String author;
  public Integer yearOfPublication;
  public Integer nbOfPages;
  public Integer rank;
  public BigDecimal price;
  public URL smallImageUrl;
  public URL mediumImageUrl;
  public String description;

  public Book(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(title, book.title) &&
      Objects.equals(isbn13, book.isbn13) &&
      Objects.equals(isbn10, book.isbn10) &&
      Objects.equals(author, book.author) &&
      Objects.equals(yearOfPublication, book.yearOfPublication) &&
      Objects.equals(nbOfPages, book.nbOfPages) &&
      Objects.equals(rank, book.rank) &&
      Objects.equals(price, book.price) &&
      Objects.equals(smallImageUrl, book.smallImageUrl) &&
      Objects.equals(mediumImageUrl, book.mediumImageUrl) &&
      Objects.equals(description, book.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, isbn13, isbn10, author, yearOfPublication, nbOfPages, rank, price, smallImageUrl, mediumImageUrl, description);
  }

  @Override
  public String toString() {
    return "Book{" +
      "title='" + title + '\'' +
      ", isbn13='" + isbn13 + '\'' +
      ", isbn10='" + isbn10 + '\'' +
      ", author='" + author + '\'' +
      ", yearOfPublication=" + yearOfPublication +
      ", nbOfPages=" + nbOfPages +
      ", rank=" + rank +
      ", price=" + price +
      ", smallImageUrl=" + smallImageUrl +
      ", mediumImageUrl=" + mediumImageUrl +
      ", description='" + description + '\'' +
      '}';
  }
}
