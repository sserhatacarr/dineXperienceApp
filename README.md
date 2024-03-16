# Dine Experience Application

[Go to Turkish README](README_TR.md)

The Dine Experience Application is a comprehensive project developed as the final assignment for the N11 TalentHub Backend Bootcamp. This application is built using a microservices architecture and consists of four main modules: `discovery-server`, `api-gateway`, `user-service`, and `restaurant-service`. The `discovery-server` acts as a service registry, enabling efficient communication between the microservices. The `api-gateway` serves as the single entry point for all client requests and forwards them to the appropriate service. The `user-service` manages users and their reviews for restaurants, providing functionalities such as user registration, review submission, and personalized restaurant recommendations based on user location and restaurant ratings. The `restaurant-service` handles all operations related to restaurants, including restaurant registration and listing, with all restaurant data stored and queried in Apache Solr.  Each service in this repository has its own README.md file that provides details about the project.


## Services

- [Discovery Server](./discovery-server/README.md): A Spring Boot application that provides service discovery and registration. It uses Netflix Eureka to register and discover services. The Discovery Service is the single entry point for all clients. It forwards requests to the appropriate service.

- [API Gateway](./api-gateway/README.md): A Spring Boot application that provides a RESTful API for managing users and restaurants. It includes operations for creating, retrieving, updating, and deleting users and restaurants. The API Gateway is the single entry point for all clients. It forwards requests to the appropriate service. It also provides a way to authenticate and authorize users.

- [User Service](./user-service/README.md): A Spring Boot application that provides a RESTful API for managing users and user reviews. It includes operations for creating, retrieving, updating, and deleting users and user reviews. Each user has associated latitude and longitude values. User reviews have a score between 1 and 5.

- [Restaurant Service](./restaurant-service/README.md): A Spring Boot application that provides a RESTful API for managing restaurants. It includes operations for creating, retrieving, updating, and deleting restaurants. Each restaurant has associated latitude and longitude values. The data for the restaurants is stored in Apache Solr and queries are also made to Solr. The service also provides an API for recommending restaurants to users based on their location and the restaurant's score.


