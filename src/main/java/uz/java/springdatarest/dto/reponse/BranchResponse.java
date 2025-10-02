package uz.java.springdatarest.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.java.springdatarest.model.Branch;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchResponse {
    private String name;
    private Long libraryId;

    public static BranchResponse toDto(Branch branch) {
        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setName(branch.getName());
        branchResponse.setLibraryId(branch.getLibrary().getId());
        return branchResponse;
    }
}
