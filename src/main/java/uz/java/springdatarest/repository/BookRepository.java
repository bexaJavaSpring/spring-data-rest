package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.java.springdatarest.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
