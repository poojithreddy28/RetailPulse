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

## Technologies Used
- **Spring Boot:** For building microservices.
- **Flyway:** Database versioning for `order-service`.
- **MongoDB TestContainer:** For integration testing in `product-service`.
- **MySQL:** Database for `order-service`.
- **MongoDB:** Database for `product-service`.
