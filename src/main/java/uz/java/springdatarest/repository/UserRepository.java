package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uz.java.springdatarest.model.User;
//@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
