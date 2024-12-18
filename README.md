# SpringBoot Microservices Project

This repository contains microservices developed using Spring Boot, demonstrating RESTful API development, database integration, and testing practices.

## Services

### 1. **Product Service**
- **Description:** Handles product-related functionalities in the system.
- **Features:**
  - **Create Product:** Adds a new product to the system.
  - **Retrieve Products:** Fetches product details from the database.
- **Tech Stack:**
  - **Spring Boot:** For REST API development.
  - **MongoDB:** Database to store product details.
  - **TestContainers:** For integration testing with MongoDB.

### 2. **Order Service**
- **Description:** Manages customer orders in the system.
- **Features:**
  - **Place Order:** Allows customers to place orders.
- **Tech Stack:**
  - **Spring Boot:** For REST API development.
  - **MySQL:** Database to store order details.
  - **Flyway:** For database schema versioning and migrations.

### 3. **Inventory Service**
- **Description:** Manages inventory details and tracks product stock levels in the system.
- **Features:**
  - **Update Inventory:** Updates stock levels when orders are placed or products are added.
  - **Retrieve Inventory:** Provides details of current stock levels for products.
  - **Read Inventory:** Checks stock in inventory using SkuCode and Quantity.
- **Tech Stack:**
  - **Spring Boot:** For REST API development.
  - **MySQL:** Database to store inventory details.
  - **Flyway:** For database schema versioning and migrations.
  - **JUnit:** For unit and integration testing of inventory-related functionalities.

### 4. **API Gateway**
- **Description:** Acts as a single entry point for all microservices, providing routing, authentication, and fault tolerance.
- **Features:**
  - **Swagger Aggregation:** Aggregates API documentation from all microservices.
  - **Resilience4J Circuit Breaker:** Adds fault tolerance for service communication.
  - **OAuth2 Security:** Configured authentication using Keycloak with JWT tokens.
- **Tech Stack:**
  - **Spring Boot:** For API gateway development.
  - **Keycloak:** For authentication and authorization.
  - **Resilience4J:** For circuit breaker implementation.


## Technologies Used
- **Spring Boot:** For building microservices.
- **Flyway:** Database versioning for `order-service`.
- **MongoDB TestContainer:** For integration testing in `product-service`.
- **MySQL:** Database for `order-service`.
- **MongoDB:** Database for `product-service`.
- **Resilience4J:** Circuit breaker for fault-tolerant communication.
- **Keycloak:** For authentication and authorization in `api-gateway`.
