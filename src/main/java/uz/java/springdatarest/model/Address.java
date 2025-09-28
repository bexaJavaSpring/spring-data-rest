package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "addresses")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String state;
  private String city;
  private String street;
  private String zip;

  @OneToOne
  @JoinColumn(name = "branch_id", referencedColumnName = "id")
  private Branch branch;
}
