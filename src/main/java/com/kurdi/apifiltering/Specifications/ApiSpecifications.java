package com.kurdi.apifiltering.Specifications;

import com.kurdi.apifiltering.enums.SearchOperations;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ApiSpecifications<T> {

    public Specification<T> getSearchSpecifications(List<SearchRequestDto> searchRequestDtos) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (searchRequestDtos == null || searchRequestDtos.isEmpty()) {
                    return null;
                }
                List<Predicate> predicates = new ArrayList<>();
                for (SearchRequestDto searchRequestDto : searchRequestDtos) {
                    switch (searchRequestDto.getOperation()) {
                        case EQUAL ->
                                predicates.add(criteriaBuilder.equal(root.get(searchRequestDto.getColumn()), searchRequestDto.getValue()));
                        case IN ->
                            //the value will be string comma separated "sheriff,menna,kurdi"
                                predicates.add(criteriaBuilder.in(root.get(searchRequestDto.getColumn()).in(Arrays.stream(searchRequestDto.getValue().split(",")).toList())));
                        case LIKE ->
                                predicates.add(criteriaBuilder.like(root.get(searchRequestDto.getColumn()), "%" + searchRequestDto.getValue() + "%"));
                        case LESS_THAN ->
                                predicates.add(criteriaBuilder.lessThan(root.get(searchRequestDto.getColumn()), searchRequestDto.getValue()));
                        case GREATER_THAN ->
                                predicates.add(criteriaBuilder.greaterThan(root.get(searchRequestDto.getColumn()), searchRequestDto.getValue()));
                        case BETWEEN -> {
                            String[] splitRangeValue = searchRequestDto.getValue().trim().split(",");
                            int min = Integer.parseInt(splitRangeValue[0]);
                            int max = Integer.parseInt(splitRangeValue[1]);
                            predicates.add(criteriaBuilder.between(root.get(searchRequestDto.getColumn()), min, max));

                        }
                        case JOIN -> {
                            if (searchRequestDto.getJoinTableOperation() == SearchOperations.EQUAL) {
                                predicates.add(criteriaBuilder.equal(root.join(searchRequestDto.getJoinTable()).get(searchRequestDto.getColumn()), searchRequestDto.getValue()));

                            }else if (searchRequestDto.getJoinTableOperation() == SearchOperations.IN){
                                predicates.add(criteriaBuilder.in(root.join(searchRequestDto.getJoinTable()).get(searchRequestDto.getColumn()).in(Arrays.stream(searchRequestDto.getValue().split(",")).toList())));

                            }else if (searchRequestDto.getJoinTableOperation() == SearchOperations.LIKE){
                                predicates.add(criteriaBuilder.like(root.join(searchRequestDto.getJoinTable()).get(searchRequestDto.getColumn()), "%" + searchRequestDto.getValue() + "%"));

                            }else if (searchRequestDto.getJoinTableOperation() == SearchOperations.LESS_THAN){
                                predicates.add(criteriaBuilder.lessThan(root.join(searchRequestDto.getJoinTable()).get(searchRequestDto.getColumn()), searchRequestDto.getValue()));

                            }else if (searchRequestDto.getJoinTableOperation() == SearchOperations.GREATER_THAN){
                                predicates.add(criteriaBuilder.greaterThan(root.join(searchRequestDto.getJoinTable()).get(searchRequestDto.getColumn()), searchRequestDto.getValue()));

                            }else if (searchRequestDto.getJoinTableOperation() == SearchOperations.BETWEEN){
                                String[] splitRangeValue = searchRequestDto.getValue().trim().split(",");
                                int min = Integer.parseInt(splitRangeValue[0]);
                                int max = Integer.parseInt(splitRangeValue[1]);
                                predicates.add(criteriaBuilder.between(root.join(searchRequestDto.getJoinTable()).get(searchRequestDto.getColumn()), min, max));
                            }
                        }
                    }

                }
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));

            }
        };
    }

    public Specification<T> getSearchSpecifications(SearchRequestDto searchRequestDtos) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (searchRequestDtos == null) {
                    return null;
                }


                return criteriaBuilder.equal(root.get(searchRequestDtos.getColumn()), searchRequestDtos.getValue());
            }
        };
    }
}
