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