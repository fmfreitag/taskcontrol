# Dockerfile para Spring Boot
FROM openjdk:11-jre-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado para o container
COPY target/taskcontrol-0.0.1-SNAPSHOT.jar taskcontrol.jar

# Expõe a porta
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "taskcontrol.jar", "--spring.profiles.active=prod"] 