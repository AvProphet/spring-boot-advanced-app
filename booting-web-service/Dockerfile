FROM maven:3.6.3-openjdk-11 as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package
RUN mv target/booting-web-service-${VERSION}.jar target/application.jar

FROM openjdk:11.0.2-jre-slim
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar