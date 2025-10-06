package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.springdatarest.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
