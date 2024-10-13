FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Vaccine.jar
ENTRYPOINT ["java","-jar","/Vaccine.jar"]
EXPOSE 9096