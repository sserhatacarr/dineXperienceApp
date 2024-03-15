# Restaurant Service

[Go to Turkish README](README_TR.md)

The Restaurant Service is a pivotal component in our microservice architecture. It is responsible for managing restaurant data and provides functionalities for creating, updating, deleting, and retrieving restaurant information. In addition to these basic CRUD operations, the Restaurant Service also offers a sophisticated recommendation feature. This feature calculates a score for each restaurant based on its distance from the user and its rating, considering only restaurants within a 10 km radius from the user. The score is a weighted combination of the restaurant's rating (70%) and its proximity to the user (30%). The service then sorts the restaurants in descending order of their scores and returns the top 3 recommendations. This recommendation feature enhances the user experience by providing personalized restaurant suggestions based on user location and restaurant ratings.

## User Client

The `UserClient` is a Feign client in the Restaurant Service. Feign is a declarative web service client that simplifies the process of writing HTTP clients. In our microservice architecture, it is used to facilitate communication between services.

In this context, the `UserClient` is used to communicate with the User Service. It has one main operation:

- `getUserById(Long id)`: This operation fetches a specific user by their ID from the User Service. It corresponds to a `GET /api/v1/users/{id}` request to the User Service.

This operation is essential for the Restaurant Service to manage restaurant recommendations for users. When the system needs to recommend restaurants to a user, the Restaurant Service uses the `UserClient` to fetch the details of the user, including their location, from the User Service. This ensures that recommendations can be personalized based on the user's location, enhancing the user experience by providing tailored restaurant suggestions.

## Restaurant Controller

The `RestaurantController` is a REST controller that provides endpoints for managing restaurant data.

### Endpoints

- `GET /api/v1/restaurants`: This endpoint returns all restaurants in the database.

- `GET /api/v1/restaurants/{id}`: This endpoint returns a restaurant by its ID. 

- `POST /api/v1/restaurants`: This endpoint saves a new restaurant to the database. It accepts a `RestaurantSaveRequest` object in the request body.

- `PUT /api/v1/restaurants`: This endpoint updates an existing restaurant in the database. It accepts a `RestaurantUpdateRequest` object in the request body and.

- `DELETE /api/v1/restaurants/{id}`: This endpoint deletes a restaurant from the database by its ID.

### Response

The responses from these endpoints are wrapped in a `RestResponse` object. This object contains the following fields:

- `data`: The data of the response. It can be a `RestaurantDTO` object, a list of `RestaurantDTO` objects, or `null` in the case of a delete operation.

- `message`: A message describing the result of the operation.

The `RestaurantDTO` object represents a restaurant and contains the following fields:

- `id`: The ID of the restaurant.
- `name`: The name of the restaurant.
- `address`: The address of the restaurant.
- `phone`: The phone number of the restaurant.
- `email`: The email of the restaurant.
- `description`: A description of the restaurant.
- `website`: The website of the restaurant.
- `workingHours`: The working hours of the restaurant.
- `latitude`: The latitude of the restaurant's location.
- `longitude`: The longitude of the restaurant's location.
- `restaurantRate`: The rating of the restaurant.
- `status`: The status of the restaurant.

## Recommendation Controller

The `RecommendationController` is a REST controller that provides an endpoint for fetching restaurant recommendations for a user.

### Endpoint

- `GET /api/v1/recommendations/{userId}`

This endpoint returns a list of recommended restaurants for the user with the given `userId`. The recommendations are calculated based on the user's location and the ratings of the restaurants.

### Response

The response is a list of `RestaurantWithScoreDTO` objects, each representing a recommended restaurant. Each object contains the following fields:

- `id`: The ID of the restaurant.
- `name`: The name of the restaurant.
- `address`: The address of the restaurant.
- `phone`: The phone number of the restaurant.
- `email`: The email of the restaurant.
- `description`: A description of the restaurant.
- `website`: The website of the restaurant.
- `workingHours`: The working hours of the restaurant.
- `latitude`: The latitude of the restaurant's location.
- `longitude`: The longitude of the restaurant's location.
- `restaurantRate`: The rating of the restaurant.
- `score`: The calculated score of the restaurant based on its distance from the user and its rating.
- `distance`: The distance of the restaurant from the user.
- `status`: The status of the restaurant.

The list is sorted in descending order of the `score` field, so the first restaurant in the list is the most recommended one.

## Recommendation Algorithm Explanation

The recommendation algorithm works by calculating a score for each restaurant based on its distance from the user and its rating. The algorithm only considers restaurants that are within a 10 km radius from the user.

The score is calculated as follows:
- 70% of the score comes from the restaurant's rating.
- 30% of the score comes from the distance of the restaurant from the user. The closer the restaurant, the higher this part of the score will be.

After calculating the scores, the algorithm sorts the restaurants in descending order of their scores and returns the top 3.
