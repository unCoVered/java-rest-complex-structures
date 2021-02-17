FROM openjdk:12-jdk-alpine
COPY build/libs/returnly-assessment-0.0.1-SNAPSHOT.jar returnly-assessment-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","returnly-assessment-0.0.1-SNAPSHOT.jar"]