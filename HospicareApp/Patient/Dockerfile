FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Patient.jar
ENTRYPOINT ["java","-jar","/Patient.jar"]
EXPOSE 9099