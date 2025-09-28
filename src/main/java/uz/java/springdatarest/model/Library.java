package uz.java.springdatarest.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "libraries")
public class Library extends Auditable {

    @Column(length = 100)
    private String name;

    @ManyToMany(mappedBy = "libraryList")
    private List<User> users = new ArrayList<>();


}
