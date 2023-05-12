FROM openjdk:17-alpine

COPY target/majorproject-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "majorproject-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082