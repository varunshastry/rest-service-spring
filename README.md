# rest-service-spring

To build, run the following in the project root directory:
mvn package spring-boot:repackage


# Contents of Dockerfile:
FROM amazoncorretto:8u302
RUN mkdir -p /app
COPY rest-api-java-springboot-project/target/rest-api-java-springboot-1.0-SNAPSHOT.jar /app/
CMD ["java", "-jar", "/app/rest-api-java-springboot-1.0-SNAPSHOT.jar"]


# build the docker image
docker build --tag flight-status-service .


# run the docker container
docker run -d -P flight-status-service
