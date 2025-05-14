# Etapa 1: Compilar la aplicación con Maven y Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copiar el contenido de tu app (código y configuración)
COPY ./ ./

# Ejecutar Maven para compilar y generar el archivo .war
RUN mvn clean package -DskipTests

FROM payara/server-full:6.2025.4-jdk17

# Variables de entorno para la base de datos
ENV POSTGRES_HOST=postgres
ENV POSTGRES_PORT=5432
ENV POSTGRES_DB=midb
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin

# Crear el directorio de despliegue (si no existe)
RUN mkdir -p /opt/payara/deployments

# Copiar el archivo WAR desde la etapa anterior al contenedor de Payara
COPY --from=builder /app/target/jakarta-postgres-app.war /opt/payara/deployments/

# Exponer el puerto 8080 para el acceso al servidor Payara
EXPOSE 8080
