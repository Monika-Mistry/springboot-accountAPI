FROM maven:latest AS maven

COPY . .

RUN ["mvn", "package"]

FROM java:8

COPY --from=maven target/AccountPrizeGeneratorAPI-0.0.1-SNAPSHOT.jar /opt/AccountPrizeGeneratorAPI-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/opt/AccountPrizeGeneratorAPI-0.0.1-SNAPSHOT.jar"]