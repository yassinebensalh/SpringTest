FROM openjdk:11-jre-slim
WORKDIR /app
ADD target/stationSki-1.5.0.jar stationSki-1.5.0.jar
EXPOSE 8089
CMD ["java", "-jar", "stationSki-1.5.0.jar"]
