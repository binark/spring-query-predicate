package io.github.binark.converter;

import io.github.binark.querypredicate.descriptor.converter.QueryDescriptorConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryDescriptorConverterTest {

  @Autowired
  QueryDescriptorConverter queryDescriptorConverter;

  @Test
  void test_bean_created() {
    Assertions.assertNotNull(queryDescriptorConverter);
  }

}
