FROM maven:latest AS maven

COPY . .

RUN ["mvn", "package"]

FROM java:8

COPY --from=maven target/AccountAPI-0.0.1-SNAPSHOT.jar /opt/AccountAPI-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/AccountAPI-0.0.1-SNAPSHOT.jar"]