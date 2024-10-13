FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Nurse.jar
ENTRYPOINT ["java","-jar","/Nurse.jar"]
EXPOSE 9094