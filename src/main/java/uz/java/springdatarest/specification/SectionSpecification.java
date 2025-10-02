package uz.java.springdatarest.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import uz.java.springdatarest.dto.filter.SectionFilter;
import uz.java.springdatarest.model.Section;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SectionSpecification implements Specification<Section> {

    private final SectionFilter filter;

    @Override
    public Predicate toPredicate(Root<Section> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getNumber() != null) {
            predicates.add(criteriaBuilder.equal(root.get("number"), filter.getNumber()));
        }
        if (filter.getLibraryId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("library").get("id"), filter.getLibraryId()));
        }
        criteriaBuilder.equal(root.get("isDeleted"), false);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
