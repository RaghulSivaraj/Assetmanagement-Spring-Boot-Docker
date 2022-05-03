FROM maven:3.5-jdk-8-alpine
LABEL Name="Assetmanagement Service"
WORKDIR /app
COPY . /app
COPY target/assetmanagement-0.0.1-SNAPSHOT.jar assetmanagement-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","assetmanagement-0.0.1-SNAPSHOT.jar", "&"]

