package uz.java.springdatarest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFilter extends BaseFilter {
    private String search;
    private String firstName;
    private String lastName;
    private String email;
}
