# Stage 1 - Build Spring Boot application using Maven
FROM maven:3.9.9-eclipse-temurin-23 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2 - Deploy War file to Tomcat server
FROM tomcat:10.1.28-jdk21-temurin

COPY --from=build /app/target/bakery-shop*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]