package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="timetables")
public class Timetable extends Auditable {

  private LocalDateTime date;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "section_id", referencedColumnName = "id")
  private Section section;
}
