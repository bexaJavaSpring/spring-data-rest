package uz.java.springdatarest.service;

import org.springframework.stereotype.Service;
import uz.java.springdatarest.dto.reponse.BookResponse;
import uz.java.springdatarest.model.Book;
import uz.java.springdatarest.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<BookResponse> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    return BookResponse.toDTO(books);
  }
}
