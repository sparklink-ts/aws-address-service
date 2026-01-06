FROM eclipse-temurin:8-jre-alpine
#FROM eclipse-temurin:8-jre-alpine
#FROM openjdk:8
EXPOSE 9002
ADD target/address-service-v2.0.0-snapshot.jar address-service-v2.0.0-snapshot.jar
ENTRYPOINT ["java", "-jar","/address-service-v2.0.0-snapshot.jar"]