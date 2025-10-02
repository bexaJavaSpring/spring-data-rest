package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uz.java.springdatarest.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long>, JpaSpecificationExecutor<Section> {
}
