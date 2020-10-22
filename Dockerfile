#### Stage 1: Build the application
FROM maven:3-jdk-11-slim as build

# Set the current working directory inside the image

WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Package the application
RUN mvn package
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app
FROM openjdk:11-jdk-slim

ARG DEPENDENCY=/app/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions","-cp","app:app/lib/*","com.spring.walmart.desafio.DesafioApplication"]