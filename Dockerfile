FROM openjdk:17-jdk-slim
COPY target/gagas-0.0.1-SNAPSHOT.jar /gagas-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/gagas-0.0.1-SNAPSHOT.jar"]