FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Prescription.jar
ENTRYPOINT ["java","-jar","/Prescription.jar"]
EXPOSE 9101