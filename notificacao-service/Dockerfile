# Dockerfile para notificacao-service
FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=target/notificacao-service-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]