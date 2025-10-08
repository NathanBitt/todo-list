# Etapa 1: Build
FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=build /app/target/todo-list-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
