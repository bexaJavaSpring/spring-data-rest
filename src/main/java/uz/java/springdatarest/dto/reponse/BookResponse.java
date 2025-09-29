package uz.java.springdatarest.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.java.springdatarest.model.Book;
import uz.java.springdatarest.model.Category;
import uz.java.springdatarest.model.Room;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookResponse {
  private String name;
  private String author;
  private Category category;
  private Room room;

  public static List<BookResponse> toDTO(List<Book> books) {
    List<BookResponse> bookResponseList = new ArrayList<>();
    for(Book book: books) {
      BookResponse bookResponse = new BookResponse();
      bookResponse.setName(book.getName());
      bookResponse.setAuthor(book.getAuthor());
      bookResponse.setCategory(book.getCategory());
      bookResponse.setRoom(book.getRoom());
      bookResponseList.add(bookResponse);
    }
    return  bookResponseList;
  }
}
