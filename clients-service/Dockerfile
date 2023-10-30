FROM openjdk:17-jdk-alpine

EXPOSE 8080

WORKDIR /app

COPY target/clients-service-1.0.0.jar app.jar

CMD ["java", "-jar", "/app/app.jar", "--spring.profiles.active=containers"]
