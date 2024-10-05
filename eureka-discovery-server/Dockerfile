FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-discovery-server.jar
ENTRYPOINT ["java","-jar","/eureka-discovery-server.jar"]
EXPOSE 8761