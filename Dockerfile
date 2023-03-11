FROM openjdk:17-jdk-alpine

COPY target/docker-challenge-products-service-1.0-SNAPSHOT.jar challenge-products-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/challenge-products-service-1.0-SNAPSHOT.jar"]