
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar.original app.jar
ENTRYPOINT ["-jar","java","/app.jar"]