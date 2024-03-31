package io.github.binark.builder;

import io.github.binark.filter.CustomerFilter;
import io.github.binark.querypredicate.builder.AbstractPredicateBuilder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import java.util.List;

public class CustomPredicateBuilder extends AbstractPredicateBuilder<CustomerFilter> {

  @Override
  public Predicate buildPredicate(Path path, CriteriaBuilder criteriaBuilder,
      CustomerFilter customerFilter, String s) {
    List<Predicate> predicates = super.buildBaseFilterPredicate(path, criteriaBuilder,
        customerFilter, s);
    return predicates.size() == 1 ? (Predicate) predicates.get(0)
        : criteriaBuilder.or((Predicate[]) predicates.toArray(new Predicate[0]));
  }
}
