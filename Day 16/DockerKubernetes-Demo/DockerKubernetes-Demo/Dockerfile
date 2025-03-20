# Use OpenJDK 17 as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Expose the port your application runs on
EXPOSE 6580

# Copy the built JAR file from target directory to the container
ADD target/DockerKubernetes-Demo.jar app.jar

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
