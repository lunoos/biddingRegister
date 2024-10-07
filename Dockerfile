FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080



ENV DB_URL=jdbc:postgresql://host.docker.internal:5432/registerDb
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=password

# Add these lines for debugging
RUN echo "DB_URL: $DB_URL"
RUN echo "DB_USERNAME: $DB_USERNAME"
RUN echo "DB_PASSWORD: $DB_PASSWORD"

# This line is crucial for Linux hosts
#RUN echo "host.docker.internal host-gateway" >> /etc/hosts

ENTRYPOINT ["java", "-jar", "app.jar"]