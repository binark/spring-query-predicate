package io.github.binark.annotation;

import io.github.binark.configuration.QueryPredicateAutoConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * EnableQueryPredicate annotation to import query predicate auto configurations
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({QueryPredicateAutoConfiguration.class})
public @interface EnableQueryPredicate {

}
