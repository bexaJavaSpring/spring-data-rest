package uz.java.springdatarest.service;

import org.springframework.stereotype.Service;
import uz.java.springdatarest.dto.filter.BranchFilter;
import uz.java.springdatarest.dto.reponse.BranchResponse;
import uz.java.springdatarest.dto.request.BranchRequest;
import uz.java.springdatarest.model.Branch;
import uz.java.springdatarest.repository.BranchRepository;
import uz.java.springdatarest.repository.LibraryRepository;
import uz.java.springdatarest.specification.BranchSpecification;
import uz.java.springdatarest.specification.Pagination;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final LibraryRepository libraryRepository;

    public BranchService(BranchRepository branchRepository, LibraryRepository libraryRepository) {
        this.branchRepository = branchRepository;
        this.libraryRepository = libraryRepository;
    }

    public List<BranchResponse> getAll(BranchFilter filter) {
        return branchRepository.findAll(new BranchSpecification(filter), Pagination.getPageable(filter.getPage(), filter.getLimit(), filter.getSortBy()))
                .map(BranchResponse::toDto).toList();
    }

    public Long create(BranchRequest request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        var library = libraryRepository.findById(request.getLibraryId()).orElseThrow(() -> new RuntimeException("Library not found"));
        branch.setLibrary(library);
        branchRepository.save(branch);
        return branch.getId();
    }

    public Long update(Long id, BranchRequest request) {
        var branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setName(request.getName());
        if (request.getLibraryId() != null) {
            var library = libraryRepository.findById(request.getLibraryId()).orElseThrow(() -> new RuntimeException("Library not found"));
            branch.setLibrary(library);
        }
        branchRepository.save(branch);
        return branch.getId();
    }

    public Boolean delete(Long id) {
        var branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setDeleted(true);
        branch.setDeletedAt(LocalDateTime.now());
        branchRepository.save(branch);
        return true;
    }

    public BranchResponse getOne(Long id) {
        return BranchResponse.toDto(branchRepository.findById(id).orElseThrow(RuntimeException::new));
    }
}
