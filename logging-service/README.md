# Logging Service

This is a logging service for a Spring Boot application. It uses Apache Kafka for message consumption and MongoDB for data storage. The service is designed to consume error logs from Kafka, store them in MongoDB, and provide an API for retrieving the logs.

## Project Structure

The project is structured into four main packages:

1. `com.serhatacarr.loggingservice.controller`: This package contains the `ErrorLogController` class which exposes a REST API for retrieving the error logs.

2. `com.serhatacarr.loggingservice.repository`: This package contains the `ErrorLogRepository` interface which extends `MongoRepository`. This interface is used for CRUD operations on the `ErrorLog` documents in MongoDB.

3. `com.serhatacarr.loggingservice.service`: This package contains the `KafkaConsumerService` class which consumes messages from a Kafka topic and saves them as `ErrorLog` documents in MongoDB.

4. `com.serhatacarr.loggingservice.entity`: This package contains the `ErrorLog` class which represents the error log documents in MongoDB.

## Usage

### Kafka Consumer

The `KafkaConsumerService` class is annotated with `@Service` and `@Slf4j` (for logging). It has a method `consume` annotated with `@KafkaListener`, which consumes messages from the Kafka topic "errorLog". The consumed message is saved as an `ErrorLog` document in MongoDB.

### Error Log Repository

The `ErrorLogRepository` interface extends `MongoRepository<ErrorLog, String>`, which provides methods for CRUD operations on `ErrorLog` documents in MongoDB.

### Error Log Controller

The `ErrorLogController` class is annotated with `@RestController` and `@RequestMapping("/api/v1/error-logs")`. It has a method `findAll` annotated with `@GetMapping`, which retrieves all `ErrorLog` documents from MongoDB and returns them as a list.

### Error Log Entity

The `ErrorLog` class is annotated with `@Document(collection = "errorlogdoc")`, `@Getter`, `@Setter`, `@AllArgsConstructor`, `@NoArgsConstructor`, and `@Builder`. It represents the error log documents in MongoDB.

## Setup

To use this service, you need to have a running instance of Apache Kafka and MongoDB. You also need to configure the Kafka topic and MongoDB connection details in the application's properties file.

## Running the Application

You can run the application using the following command:

```bash
mvn spring-boot:run
```

Once the application is running, you can access the API at `http://localhost:8080/api/v1/error-logs`.

## Contact

### Serhat Acar

<a href="https://github.com/sserhatacarr" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:sserhatacarr@gmail.com?subject = Feedback&body = Message">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=gmail style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/sserhatacarr" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  

## Talenthub Bootcamp - N11 & Patika

<div align="center">
  <a href="https://www.n11.com/">
    <img src="../img/n11-logo.png" alt="Logo" width="220" height="140">
  </a>

<h3 align="center">Company: N11.com</h3>
</div>

<div align="center">
  <a href="https://www.patika.dev/">
    <img src="../img/patika-logo.png" alt="Logo" width="350" height="300">
  </a>
<h3 align="center">Organizer: Patika.dev</h3>   
</div>