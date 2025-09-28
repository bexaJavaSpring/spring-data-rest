package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String author;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="category_id", referencedColumnName = "id")
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="room_id", referencedColumnName = "id")
  private Room room;

}
