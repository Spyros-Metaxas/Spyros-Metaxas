FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} client-diplomathesis.jar
ENTRYPOINT ["java","-jar","/client-diplomathesis.jar"]
EXPOSE 9999