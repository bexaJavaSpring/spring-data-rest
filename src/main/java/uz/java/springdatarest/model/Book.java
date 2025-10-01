package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
@Builder
public class Book extends Auditable {
  @Column(unique = true)
  private String name;

  private String author;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="category_id", referencedColumnName = "id")
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="room_id", referencedColumnName = "id")
  private Room room;

}
