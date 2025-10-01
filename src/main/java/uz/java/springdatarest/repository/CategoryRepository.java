package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.springdatarest.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
