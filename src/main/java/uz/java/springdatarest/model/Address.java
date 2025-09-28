package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address extends Auditable {

  private String state;
  private String city;
  private String street;
  private String zip;

  @OneToOne
  @JoinColumn(name = "branch_id", referencedColumnName = "id")
  private Branch branch;
}
