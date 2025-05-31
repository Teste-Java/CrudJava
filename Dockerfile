# Etapa 1: Build do projeto usando Maven + Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos necessários para compilar
COPY pom.xml .
COPY src ./src

# Gera o .jar (modo JVM)
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final leve apenas com o Java
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o jar gerado pelo Quarkus (modo JVM)
COPY --from=build /app/target/quarkus-app/quarkus-run.jar app.jar

# Expõe a porta padrão usada pelo Quarkus
EXPOSE 8080

# Garante compatibilidade de rede com Render/Railway
ENV JAVA_OPTS="-Djava.net.preferIPv4Stack=true"

# Comando para rodar sua API
CMD ["java", "-jar", "app.jar"]
