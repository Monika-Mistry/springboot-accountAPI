FROM maven:latest AS maven

COPY . .

RUN ["mvn", "package"]

FROM java:8

COPY --from=maven target/AccountNumberGeneratorAPI-0.0.1-SNAPSHOT.jar /opt/AccountNumberGeneratorAPI-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/opt/AccountNumberGeneratorAPI-0.0.1-SNAPSHOT.jar"]