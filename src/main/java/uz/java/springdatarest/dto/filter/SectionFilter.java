package uz.java.springdatarest.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.java.springdatarest.dto.BaseFilter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SectionFilter extends BaseFilter {
    private Integer number;
    private Long libraryId;
}
