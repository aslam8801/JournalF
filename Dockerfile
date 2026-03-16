# ---------- Stage 1: Build ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only pom.xml first to cache dependencies
COPY pom.xml .

# Download dependencies (this layer will be cached)
RUN mvn -B dependency:go-offline

# Now copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run ----------
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/journalApp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]