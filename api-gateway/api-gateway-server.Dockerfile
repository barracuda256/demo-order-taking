#
# Build stage
#
FROM gradle:8.2.1-jdk17 AS builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build
#RUN ./gradlew clean build

#
# Package stage
#
FROM openjdk:17
WORKDIR /app
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
