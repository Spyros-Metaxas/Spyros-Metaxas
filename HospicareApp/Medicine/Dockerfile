FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Medicine.jar
ENTRYPOINT ["java","-jar","/Medicine.jar"]
EXPOSE 9092