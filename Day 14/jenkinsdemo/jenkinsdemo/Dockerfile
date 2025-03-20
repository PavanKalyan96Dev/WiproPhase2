# Use official OpenJDK as a base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the correct JAR file into the container
COPY target/jenkinsdemo-0.0.1-SNAPSHOT.jar myapp.jar

# Run the application
CMD ["java", "-jar", "myapp.jar"]

# Expose port 8080
EXPOSE 8080
