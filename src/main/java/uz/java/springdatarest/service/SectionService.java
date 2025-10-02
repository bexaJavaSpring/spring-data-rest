package uz.java.springdatarest.service;

import org.springframework.stereotype.Service;
import uz.java.springdatarest.dto.filter.SectionFilter;
import uz.java.springdatarest.dto.reponse.SectionResponse;
import uz.java.springdatarest.dto.request.SectionRequest;
import uz.java.springdatarest.model.Library;
import uz.java.springdatarest.model.Section;
import uz.java.springdatarest.repository.LibraryRepository;
import uz.java.springdatarest.repository.SectionRepository;
import uz.java.springdatarest.specification.Pagination;
import uz.java.springdatarest.specification.SectionSpecification;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final LibraryRepository libraryRepository;

    public SectionService(SectionRepository sectionRepository, LibraryRepository libraryRepository) {
        this.sectionRepository = sectionRepository;
        this.libraryRepository = libraryRepository;
    }

    public List<SectionResponse> getAll(SectionFilter filter) {
        return sectionRepository.findAll(new SectionSpecification(filter),
                        Pagination.getPageable(filter.getPage(), filter.getLimit(), filter.getSortBy()))
                .map(SectionResponse::toDto).toList();
    }

    public Long create(SectionRequest request) {
        var section = new Section();
        section.setNumber(request.getNumber());
        Library library = libraryRepository.findById(request.getLibraryId()).orElseThrow(() -> new RuntimeException("Library not found"));
        section.setLibrary(library);
        sectionRepository.save(section);
        return section.getId();
    }

    public Long update(Long id, SectionRequest request) {
        var section = sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
        section.setNumber(request.getNumber());
        if (request.getLibraryId() != null) {
            Library library = libraryRepository.findById(request.getLibraryId()).orElseThrow(() -> new RuntimeException("Library not found"));
            libraryRepository.save(library);
        }
        sectionRepository.save(section);
        return section.getId();
    }

    public Boolean delete(Long id) {
        var section = sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
        section.setDeleted(true);
        section.setDeletedAt(LocalDateTime.now());
        sectionRepository.save(section);
        return true;
    }

    public SectionResponse getOne(Long id) {
        var section = sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
        return SectionResponse.toDto(section);
    }
}
