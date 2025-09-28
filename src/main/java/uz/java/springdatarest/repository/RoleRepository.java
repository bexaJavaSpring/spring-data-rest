package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.springdatarest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
