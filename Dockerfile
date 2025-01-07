# Use a base image with Java support
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file or source code (adapt this step as needed)
COPY target/SearchService-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the service uses (update the port as per your configuration)
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
