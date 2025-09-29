package uz.java.springdatarest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.java.springdatarest.dto.UserFilter;
import uz.java.springdatarest.dto.reponse.BookResponse;
import uz.java.springdatarest.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public List<BookResponse> getAll() {
    return bookService.getAllBooks();
  }

}
