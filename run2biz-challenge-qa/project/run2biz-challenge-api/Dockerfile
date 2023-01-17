FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

RUN apt-get update && \
    apt-get install dos2unix -y

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN dos2unix mvnw && \
    chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]