FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Appointment.jar
ENTRYPOINT ["java","-jar","/Appointment.jar"]
EXPOSE 9102