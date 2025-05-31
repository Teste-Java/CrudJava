# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos do projeto para a imagem
COPY pom.xml .
COPY src ./src

# Compila o projeto (gera o .jar em target/)
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com Java apenas
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR do build anterior
COPY --from=build /app/target/*-runner.jar app.jar

# Expõe a porta padrão do Quarkus
EXPOSE 8080

# Permite entrada de variáveis (ex: Railway, Docker Cloud, etc)
ENV JAVA_OPTS="-Djava.net.preferIPv4Stack=true"

# Comando para iniciar a API
CMD ["java", "-jar", "app.jar"]
