package uz.java.springdatarest.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BranchFilter extends BaseFilter{
    private String name;
    private Long libraryId;
}
