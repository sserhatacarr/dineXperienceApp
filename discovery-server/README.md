# Discovery Service

[Go to Turkish README](README_TR.md)

The Discovery Service is a key component in our microservice architecture. It allows for the registration of microservices and enables service discovery, which is essential for load balancing and failover of services.

## Key Features

- Registers all microservices.
- Enables service discovery for load balancing and failover.
- Integrates with Spring Boot and Eureka.

## Configuration

The configuration of the Discovery Service is found in the `application.yml` file. This file specifies the port the service will run on and the Eureka client configuration.

## Docker

This service is packaged to run on Docker. The Dockerfile specifies how the Docker image will be built.

## Running

You can use the following commands to build and run the Docker image:

```bash
docker build -t discovery-service .
docker run -p 8761:8761 discovery-service
```

These commands first build the Docker image and then run the discovery-service on port 8761.

## Dependencies

- **Spring Boot:** The Discovery Service is built using Spring Boot.
- **Eureka Server:** The Discovery Service uses the Eureka Server for service registration and discovery.

Please note that all microservices should register with the Discovery Service for service discovery to function correctly.