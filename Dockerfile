FROM openjdk:17-oracle
EXPOSE 9011
ARG JAR_FILE=target/config-client-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} config-client2.jar
ENTRYPOINT ["java","-jar","/config-client2.jar"]