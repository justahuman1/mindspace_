FROM maven:3.6.3-jdk-14 AS builder
WORKDIR /app
COPY src/pom.xml .
RUN mvn -e -B dependency:resolve
COPY src/src ./src
RUN mvn -e -B package

FROM openjdk:14
COPY --from=builder /app/target/mindspace.jar /
EXPOSE 9071
CMD ["java", "-jar", "/mindspace.jar"]

