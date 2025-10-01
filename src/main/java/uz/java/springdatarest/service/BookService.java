package uz.java.springdatarest.service;

import org.springframework.stereotype.Service;
import uz.java.springdatarest.dto.reponse.BookResponse;
import uz.java.springdatarest.dto.request.BookRequest;
import uz.java.springdatarest.model.Book;
import uz.java.springdatarest.model.Category;
import uz.java.springdatarest.model.Room;
import uz.java.springdatarest.repository.BookRepository;
import uz.java.springdatarest.repository.CategoryRepository;
import uz.java.springdatarest.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;
  private final RoomRepository roomRepository;

  public BookService(BookRepository bookRepository, CategoryRepository categoryRepository, RoomRepository roomRepository) {
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
    this.roomRepository = roomRepository;
  }

  public List<BookResponse> getAllBooks() {
    return bookRepository.findAll()
            .stream()
            .filter(item -> !item.isDeleted())
            .map(BookResponse::toDTO)
            .toList();
  }

  public BookResponse getById(Long id) {
    Optional<Book> bookOptional = bookRepository.findById(id);
    if (bookOptional.isPresent()) {
      return BookResponse.toDTO(bookOptional.get());
    } else {
      throw new RuntimeException("Book not found");
    }
  }

  public Long createBook(BookRequest bookRequest) {
    Category category = categoryRepository.findById(bookRequest.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found"));

    Room room = roomRepository.findById(bookRequest.getRoomId())
            .orElseThrow(() -> new RuntimeException("Room not found"));

    Book book = Book.builder()
            .name(bookRequest.getName())
            .author(bookRequest.getAuthor())
            .category(category)
            .room(room)
            .build();

    bookRepository.save(book);
    return book.getId();
  }

  public Long updateBook(BookRequest bookRequest, Long id) {
    Optional<Book> bookOptional = bookRepository.findById(id);
    if (bookOptional.isEmpty()) {
      throw new RuntimeException("book not found");
    }
    Book book = bookOptional.get();
    if (bookRequest.getName() != null) book.setName(bookRequest.getName());
    if (bookRequest.getAuthor() != null) book.setAuthor(bookRequest.getAuthor());
    if (bookRequest.getCategoryId() != null) {
      Category category = categoryRepository.findById(bookRequest.getCategoryId())
              .orElseThrow(() -> new RuntimeException("Category not found"));
      book.setCategory(category);
    }
    if (bookRequest.getRoomId() != null) {
      Room room = roomRepository.findById(bookRequest.getRoomId())
              .orElseThrow(() -> new RuntimeException("Category not found"));
      book.setRoom(room);
    }
    return bookRepository.save(book).getId();
  }

  public Boolean delete(Long id) {
    Optional<Book> bookOptional = bookRepository.findById(id);
    if (bookOptional.isEmpty()) {
      throw new RuntimeException("Book not found");
    }
    Book book = bookOptional.get();
    book.setDeleted(true);
    bookRepository.save(book);
    return true;
  }
}
