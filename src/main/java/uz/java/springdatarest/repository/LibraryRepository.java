package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.springdatarest.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
