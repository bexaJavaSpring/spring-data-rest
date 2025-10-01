package uz.java.springdatarest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseFilter {
    private Integer page;
    private Integer limit;
    private String sortBy;
}
