# Dockerfile para estoque-service
FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=target/estoque-service-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]