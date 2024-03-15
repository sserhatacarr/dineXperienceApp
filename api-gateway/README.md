
# API Gateway Service

[Go to Turkish README](README_TR.md)

The API Gateway is the central entry point for all services in our microservice architecture. This service routes incoming requests to the relevant microservices.

## Key Features

- Routes to Restaurant and User services.
- Integrates with Eureka Discovery Server.
- Provides tracing support with Zipkin.

## Configuration

The configuration of the API Gateway is found in the `application.yml` file. This file specifies the port the service will run on, which services it will route to, and how it will integrate with Eureka and Zipkin.

## Docker

This service is packaged to run on Docker. The `Dockerfile` specifies how the Docker image will be built.

## Running

You can use the following commands to build and run the Docker image:

```bash
docker build -t api-gateway .
docker run -p 8080:8080 api-gateway
```

These commands first build the Docker image and then run the `api-gateway` service on port 8080.

## Dependencies

- Restaurant Service: The API Gateway routes requests to the Restaurant Service at the `/api/v1/restaurants/**` path.
- User Service: The API Gateway routes requests to the User Service at the `/api/v1/users/**` path.
- Eureka Discovery Server: The API Gateway integrates with the Eureka Discovery Server for service discovery.
- Zipkin: The API Gateway integrates with Zipkin for tracing.

