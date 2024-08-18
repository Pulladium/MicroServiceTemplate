FROM ubuntu:latest
LABEL authors="SuperArtem"


FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /build/libs/main-0.0.1-SNAPSHOT.jar /app/main.jar
ENTRYPOINT ["java", "-jar", "main.jar"]
#ENTRYPOINT ["top", "-b"]