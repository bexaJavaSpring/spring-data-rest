package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="timetables")
public class Timetable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp date;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "section_id", referencedColumnName = "id")
  private Section section;
}
