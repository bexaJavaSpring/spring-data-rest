package uz.java.springdatarest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role extends Auditable {

  private String name;
  private String code;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;
}
