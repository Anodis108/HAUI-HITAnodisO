## build stage ##
FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app
COPY . .
RUN mvn install -DskipTests=true

## run stage ##
FROM openjdk:19-jdk-alpine3.16

WORKDIR /run
COPY --from=build /app/target/project-base-1.0.jar /run/project-base-1.0.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/run/profile-processing-1.0.jar"]