package io.github.binark.registry;

import io.github.binark.builder.CustomPredicateBuilder;
import io.github.binark.filter.CustomerFilter;
import io.github.binark.querypredicate.builder.PredicateBuilder;
import io.github.binark.querypredicate.management.BasePredicateBuilderResolver;
import io.github.binark.querypredicate.management.PredicateBuilderRegistry;
import io.github.binark.querypredicate.management.PredicateBuilderResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PredicateBuilderRegistryTest {

  @Autowired
  PredicateBuilderRegistry predicateBuilderRegistry;

  PredicateBuilderResolver predicateBuilderResolver = new BasePredicateBuilderResolver();

  @Test
  void testBeanCreated() {
    Assertions.assertNotNull(predicateBuilderRegistry);
  }

  @Test
  void testPredicateBuilderRegistration() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> predicateBuilderResolver.resolverPredicateBuilder(
            CustomerFilter.class));
    predicateBuilderRegistry.replacePredicateBuilder(CustomerFilter.class,
        new CustomPredicateBuilder());
    Assertions.assertDoesNotThrow(() -> predicateBuilderResolver.resolverPredicateBuilder(
        CustomerFilter.class));
    PredicateBuilder predicateBuilder = predicateBuilderResolver.resolverPredicateBuilder(
        CustomerFilter.class);
    Assertions.assertInstanceOf(CustomPredicateBuilder.class, predicateBuilder);
  }

}
