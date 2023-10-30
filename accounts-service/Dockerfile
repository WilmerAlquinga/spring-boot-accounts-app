FROM openjdk:17-jdk-alpine

EXPOSE 9090

WORKDIR /app

COPY target/accounts-service-1.0.0.jar app.jar

CMD ["java", "-jar", "/app/app.jar", "--spring.profiles.active=containers"]
