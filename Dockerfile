FROM openjdk:11-jre-slim
WORKDIR /app
ADD target/stationSki-2.0.0.jar stationSki-2.0.0.jar
EXPOSE 8089
CMD ["java", "-jar", "stationSki-2.0.0.jar"]
