# Etapa 1: Build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Runtime com Java + estrutura completa do quarkus-app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia toda a estrutura do Quarkus (necessária para rodar corretamente)
COPY --from=build /app/target/quarkus-app/ ./

EXPOSE 8080

ENV JAVA_OPTS="-Djava.net.preferIPv4Stack=true"

# Correto: o JAR principal agora é quarkus-run.jar
CMD ["java", "-jar", "quarkus-run.jar"]
