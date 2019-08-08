FROM maven:latest AS maven

COPY . .

RUN ["mvn", "package"]

FROM java:8

COPY --from=maven target/AccountConsumer-0.0.1-SNAPSHOT.jar /opt/AccountConsumer-0.0.1-SNAPSHOT.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/opt/AccountConsumer-0.0.1-SNAPSHOT.jar"]