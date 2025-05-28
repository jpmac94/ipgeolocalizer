FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ipgeolocalizer/target/ipgeolocalizer-0.0.1-SNAPSHOT.jar ipgeolocalizer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ipgeolocalizer.jar"]
