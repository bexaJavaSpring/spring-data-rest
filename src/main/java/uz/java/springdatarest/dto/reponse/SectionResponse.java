package uz.java.springdatarest.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.java.springdatarest.model.Section;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SectionResponse {
    private Integer number;
    private Long libraryId;

    public static SectionResponse toDto(Section section) {
        SectionResponse dto = new SectionResponse();
        dto.setNumber(section.getNumber());
        dto.setLibraryId(section.getLibrary().getId());
        return dto;
    }
}
