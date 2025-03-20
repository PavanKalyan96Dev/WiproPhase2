FROM eclipse-temurin:19
LABEL maintainer="pavan@wipro.com"

WORKDIR /app

# Ensure correct JAR file name
COPY target/springboot-mysql-docker-latest.jar /app/springboot-mysql.jar

# Use the correct path in ENTRYPOINT
ENTRYPOINT ["java", "-jar", "/app/springboot-mysql.jar"]
