FROM eclipse-temurin:21.0.1_12-jdk

WORKDIR /

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

COPY src ./src
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix mvnw && apt-get --purge remove -y dos2unix && rm -rf /var/lib/apt/lists/*

RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

ENTRYPOINT ["java","-jar","/target/logging-service-0.0.1-SNAPSHOT.jar"]