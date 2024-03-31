# SPRING QUERY PREDICATE

## [QUERY PREDICATE](https://github.com/binark/query-predicate) integration with Spring boot.

This package is built with  
**Java version: 17**  
**Query Predicate version: 1.1.0**  
**Spring version: 3.2.3**

## 1. INSTALLATION

## 1.2 Maven

```
<dependency>
	    <groupId>io.github.binark</groupId>
	    <artifactId>spring-query-predicate</artifactId>
	    <version>${version}</version>
</dependency>
```

## 1.3 Gradle

```
dependencies {
    implementation 'io.github.binark:spring-query-predicate:${version}'
}
```

## 2. CONFIGURATION

```java
import io.github.binark.annotation.EnableQueryPredicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableQueryPredicate
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
```

## 3. USAGE

## 3.1 Create a service

```java

@Service
public class MyService {

  private final QueryDescriptorConverter<MyQueryDescriptor> queryDescriptorConverter;
  private final MyRepository repository;

  public UserAccountService(QueryDescriptorConverter<MyQueryDescriptor> queryDescriptorConverter,
      MyRepository repository) {
    this.queryDescriptorConverter = queryDescriptorConverter;
    this.repository = repository;
  }

  public List<MyEntity> search(MyQueryDescriptor queryDescriptor) {
    Specification<MyEntity> userAccountSpecification = specificationBuilder(queryDescriptor);
    return repository.findAll(userAccountSpecification);
  }

  private Specification<MyEntity> specificationBuilder(
      MyQueryDescriptor queryDescriptor) {
    return (root, query, builder) -> {
      List<Predicate> predicates = queryDescriptorConverter.convert(root, builder, queryDescriptor);
      return builder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
```

## 3.2 Create a controller

```java

@RestController
@RequestMapping("/test")
public class MyController {

  private final MyService myService;

  public MyController(MyService myService) {
    this.myService = myService;
  }

  @GetMapping
  public List<MyEntity> search(MyQueryDescriptor myQueryDescriptor) {
    return myService.search(myQueryDescriptor);
  }
}
```

Now you can make a http request like  
**http://[domain]:[port]/test?[field].[constraint]=[foo]**    
where   
_**[field]**_ is a MyQueryDescriptor property  
_**[constraint]**_ is a filter constraint. Example: contains for StringFilter  
_**[foo]**_ is a value

let us assume that you are in your local PC and the MyQueryDescriptor class has a field named 'name'
which is a StringFilter type.
the query could be:
http://localhost:8080/test?name.contains=foo

### To learn more about query predicate and filters, follow the link bellow

https://github.com/binark/query-predicate