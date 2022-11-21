FROM openjdk:17

ARG JAR_FILE=gatihaeyo-infrastructure/build/libs/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "app.jar"]