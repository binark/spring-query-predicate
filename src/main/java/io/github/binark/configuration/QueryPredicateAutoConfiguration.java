package io.github.binark.configuration;

import io.github.binark.querypredicate.descriptor.converter.QueryDescriptorConverter;
import io.github.binark.querypredicate.management.PredicateBuilderRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Query predicate auto configuration to initialize all beans needed to use query predicate features
 * with Spring boot application
 */
@Configuration
public class QueryPredicateAutoConfiguration {

  /**
   * queryDescriptorConverter bean
   *
   * @return {@link QueryDescriptorConverter}
   */
  @Bean
  @ConditionalOnMissingBean
  public QueryDescriptorConverter queryDescriptorConverter() {
    return new QueryDescriptorConverter<>();
  }

  /**
   * predicateBuilderRegistry bean
   *
   * @return {@link PredicateBuilderRegistry}
   */
  @Bean
  @ConditionalOnMissingBean
  public PredicateBuilderRegistry predicateBuilderRegistry() {
    return new PredicateBuilderRegistry();
  }

}
