FROM openjdk:24-ea-21-slim-bullseye

WORKDIR /app
COPY target/Mosweet-0.0.1-SNAPSHOT.jar Mosweet.jar

LABEL authors="nata155630"

ENTRYPOINT ["java", "-jar", "Mosweet.jar"]