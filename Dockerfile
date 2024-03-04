FROM openjdk:latest
WORKDIR /app
COPY build/libs/Task-2-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]