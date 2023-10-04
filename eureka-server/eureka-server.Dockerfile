#
# Build stage
#
FROM gradle:8.2.1-jdk17 AS builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

#
# Package stage
#
FROM openjdk:17
WORKDIR /app
#COPY --from=builder /home/gradle/src/application.yaml /app/application.yaml
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar app.jar" ]
