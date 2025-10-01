package uz.java.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.springdatarest.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
