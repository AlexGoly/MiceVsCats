# Alpine because it's lighter
FROM openjdk:17-jdk-slim
MAINTAINER Alex Maksymov <eskander.goli@gmail.com>

# Add JAR file and run it as entrypoint
ADD build/libs/mice-service-0.0.1-SNAPSHOT.jar app.jar
ADD build/resources/main/application.yaml application.yaml

ENTRYPOINT ["java", "-jar", "/app.jar"]

