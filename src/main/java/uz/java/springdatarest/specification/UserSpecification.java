package uz.java.springdatarest.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import uz.java.springdatarest.dto.UserFilter;
import uz.java.springdatarest.model.User;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserSpecification implements Specification<User> {

    private final UserFilter filter;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getEmail() != null) {
            predicates.add(criteriaBuilder.like(root.get("email"), "%" + filter.getEmail() + "%"));
        }

        if (filter.getFirstName() != null) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + filter.getFirstName() + "%"));
        }
        if (filter.getLastName() != null) {
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + filter.getLastName() + "%"));
        }
        criteriaBuilder.equal(root.get("isDeleted"), false);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
