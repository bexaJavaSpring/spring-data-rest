package uz.java.springdatarest.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.java.springdatarest.model.Book;
import uz.java.springdatarest.model.Category;
import uz.java.springdatarest.model.Room;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookResponse {
  private String name;
  private String author;
  private Category category;
  private Room room;

  public static BookResponse toDTO(Book book) {
//    BookResponse bookResponse = new BookResponse();
//    bookResponse.setName(books.getName());
//    bookResponse.setAuthor(books.getAuthor());
//    bookResponse.setCategory(books.getCategory());
//    bookResponse.setRoom(books.getRoom());
//    return bookResponse;

    return BookResponse.builder()  // Barcha fieldlarni chiqarib beryabti!!!
            .name(book.getName())
            .author(book.getAuthor())
            .category(book.getCategory())
            .room(book.getRoom())
            .build();
  }
}
