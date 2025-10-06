package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="branches")
public class Branch extends Auditable {

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="library_id", referencedColumnName = "id", nullable=false)
  private Library library;

  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;


}
