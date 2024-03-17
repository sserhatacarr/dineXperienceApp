# User Service

[Go to Turkish README](README_TR.md)

The User Service is a key component in our microservice architecture. It is responsible for managing user data and provides functionalities for creating, updating, deleting, and retrieving user information. In addition to these basic CRUD operations, the User Service also manages user reviews for restaurants. Each review includes a score between 1 and 5. The User Service enhances the user experience by allowing users to share their opinions and experiences about restaurants.

## Restaurant Client

The `RestaurantClient` is a Feign client in the User Service. Feign is a declarative web service client that makes writing HTTP clients easier. In our microservice architecture, it is used to communicate between services.

In this case, the `RestaurantClient` is used to communicate with the Restaurant Service. It has two main operations:

- `getAllRestaurants()`: This operation fetches all restaurants from the Restaurant Service. It corresponds to a `GET /api/v1/restaurants` request to the Restaurant Service.

- `getRestaurantById(String id)`: This operation fetches a specific restaurant by its ID from the Restaurant Service. It corresponds to a `GET /api/v1/restaurants/{id}` request to the Restaurant Service.

These operations are crucial for the User Service to manage user reviews for restaurants. When a user wants to review a restaurant, the User Service uses the `RestaurantClient` to fetch the details of the restaurant from the Restaurant Service. This ensures that users can only review existing restaurants and allows the User Service to display up-to-date information about the restaurants being reviewed.

## User Controller

The `UserController` is a REST controller that provides endpoints for managing user data.

### Endpoints

- `GET /api/v1/users`: This endpoint returns all users in the database.

- `GET /api/v1/users/{id}`: This endpoint returns a user by its ID.

- `POST /api/v1/users`: This endpoint saves a new user to the database. It accepts a `UserSaveRequest` object in the request body.

- `PUT /api/v1/users/{debugId}`: This endpoint updates an existing user in the database. It accepts a `UserUpdateRequest` object in the request body.

- `DELETE /api/v1/users/{id}`: This endpoint deletes a user from the database by its ID.

### Response

The responses from these endpoints are wrapped in a `RestResponse` object. This object contains the following fields:

- `data`: The data of the response. It can be a `UserDTO` object, a list of `UserDTO` objects, or `null` in the case of a delete operation.

- `message`: A message describing the result of the operation.

The `UserDTO` object represents a user and contains the following fields:

- `id`: The ID of the user.
- `name`: The name of the user.
- `email`: The email of the user.
- `latitude`: The latitude of the user's location.
- `longitude`: The longitude of the user's location.


## User Review Controller

The `UserReviewController` is a REST controller that provides endpoints for managing user reviews.

### Endpoints

- `GET /api/v1/users/reviews/{id}`: This endpoint returns a user review by its ID.

- `POST /api/v1/users/reviews`: This endpoint creates a new user review. It accepts a `UserReviewSaveRequest` object in the request body.

- `GET /api/v1/users/reviews/all`: This endpoint returns all user reviews. 

- `GET /api/v1/users/reviews/user/{userId}`: This endpoint returns user reviews by user ID.

- `GET /api/v1/users/reviews/restaurant/{restaurantId}`: This endpoint returns user reviews by restaurant ID. 

- `PUT /api/v1/users/reviews`: This endpoint edits a user review. It accepts a `UserReviewUpdateRequest` object in the request body.

- `DELETE /api/v1/users/reviews/{id}`: This endpoint deletes a user review by its ID.

### Response

The responses from these endpoints are wrapped in a `RestResponse` object. This object contains the following fields:

- `data`: The data of the response. It can be a `UserReviewDetailDTO` object, a list of `UserReviewDetailDTO` objects, or `null` in the case of a delete operation.

- `message`: A message describing the result of the operation.

The `UserReviewDetailDTO` object represents a user review and contains the following fields:

- `id`: The ID of the user review.
- `userId`: The ID of the user who made the review.
- `restaurantId`: The ID of the restaurant that was reviewed.
- `score`: The score given by the user.
- `text`: The text of the review.

## Testing

Unit and integration tests are provided for the User Service. These tests ensure that the service functions as expected when interacting with the database and handling HTTP requests.

## Contact

### Serhat Acar

<a href="https://github.com/sserhatacarr" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:sserhatacarr@outlook.com?subject = Feedback&body = Message">
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

