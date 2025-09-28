package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sections")
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer number;

  @ManyToOne
  @JoinColumn(name = "library_id", referencedColumnName = "id")
  private Library library;

  @OneToOne
  @JoinColumn(name = "timetable_id", referencedColumnName = "id")
  private Timetable timetable;
}
