# spring-boot-board

A Q&A bulletin board built with Spring Boot, following the book *Do it! Jump to Spring Boot 3*. Users can post questions and answers.

## Tech Stack

- Java 21, Spring Boot 3.5.5 (Gradle)
- Spring Web (MVC), Spring Data JPA, Hibernate
- H2 database (file-based, `jdbc:h2:~/local`) with the H2 web console at `/h2-console`
- Thymeleaf with the Thymeleaf Layout Dialect, Bootstrap
- Bean Validation (`spring-boot-starter-validation`)
- Lombok

## Run

```
./gradlew bootRun
```

Then open [http://localhost:8080](http://localhost:8080)
