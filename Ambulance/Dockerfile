FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Ambulance.jar
ENTRYPOINT ["java","-jar","/Ambulance.jar"]
EXPOSE 9095