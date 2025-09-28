package uz.java.springdatarest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFilter extends BaseFilter {
    private String search;
    private String firstName;
    private String lastName;
    private String email;
}
