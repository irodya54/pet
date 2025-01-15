## Build stage
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

## Package stage
FROM openjdk:21-jdk-slim

ENV issure.uri 'http://localhost:8080/realms/pet_service'
ENV issure.secret 'fjLDghJPgY5schGbuKoNvqeWTnJKaOh8'

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/facade-service-1.0.0.jar
ENTRYPOINT ["java","-jar","/app/cfacade-service-1.0.0.jar"]