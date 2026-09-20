FROM eclipse-temurin:21-alpine
COPY application/target/api-produto.application-0.0.1-SNAPSHOT.jar api-produto.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev,infra_dev", "-jar", "api-produto.jar"]