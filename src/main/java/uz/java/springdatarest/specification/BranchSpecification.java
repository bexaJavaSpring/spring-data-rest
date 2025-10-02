package uz.java.springdatarest.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import uz.java.springdatarest.dto.filter.BranchFilter;
import uz.java.springdatarest.model.Branch;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BranchSpecification implements Specification<Branch> {

    private final BranchFilter filter;

    @Override
    public Predicate toPredicate(Root<Branch> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getName() != null)
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + filter.getName() + "%"));
        if (filter.getLibraryId() != null)
            predicates.add(criteriaBuilder.equal(root.get("libraryId"), filter.getLibraryId()));

        criteriaBuilder.equal(root.get("isDeleted"), false);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
