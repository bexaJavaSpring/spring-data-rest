package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.springdatarest.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

}
