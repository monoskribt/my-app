FROM openjdk:latest
WORKDIR /app
COPY . .
ENTRYPOINT ["java", "-jar", "app.jar"]
