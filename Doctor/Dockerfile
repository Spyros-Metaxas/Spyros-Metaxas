FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Doctor.jar
ENTRYPOINT ["java","-jar","/Doctor.jar"]
EXPOSE 9091