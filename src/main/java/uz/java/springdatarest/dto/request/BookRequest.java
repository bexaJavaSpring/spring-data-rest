package uz.java.springdatarest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.java.springdatarest.model.Category;
import uz.java.springdatarest.model.Room;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequest {
  private String name;
  private String author;
  private Long categoryId;
  private Long roomId;

}
