package uz.java.springdatarest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionRequest {
    private Integer number;
    private Long libraryId;
}
