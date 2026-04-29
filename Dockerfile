FROM --platform=linux/amd64 eclipse-temurin:21-jdk-jammy as build
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
COPY --from=build target/Alaga-English-Hub-API-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
