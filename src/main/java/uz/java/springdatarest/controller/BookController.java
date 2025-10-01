package uz.java.springdatarest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.java.springdatarest.dto.reponse.BookResponse;
import uz.java.springdatarest.dto.request.BookRequest;
import uz.java.springdatarest.model.Book;
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
  public ResponseEntity<List<BookResponse>> getAll() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookResponse> getOne(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Long> create(@RequestBody BookRequest bookRequest){
    return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Long> update(@RequestBody BookRequest bookRequest,  @PathVariable Long id) {
    return new ResponseEntity<>(bookService.updateBook(bookRequest,id), HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.delete(id));
  }

}
