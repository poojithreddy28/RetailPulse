# RetailPulse - Microservices Project 🚀

This repository contains microservices developed using Spring Boot, demonstrating RESTful API development, database integration, asynchronous communication, observability, testing practices, and Kubernetes deployment.

## Technical Architecture
![SpringBoot-Microservices](https://github.com/user-attachments/assets/0d8f2a84-ccb7-4a94-a0fb-bddb06a87980)

## Services

### 1. **Product Service** 📦
- **Description:** Handles product-related functionalities in the system.
- **Features:**
  - **Create Product:** Adds a new product to the system.
  - **Retrieve Products:** Fetches product details from the database.
  - **SKU Code Support:** Introduced SKU code to uniquely identify products.
- **Observability Enhancements:**
  - Configured **Prometheus** for tracking metrics 📊.
  - Integrated **Loki** for centralized log aggregation 📝.
  - Set up **Tempo** for distributed tracing 🕵️‍♂️.
- **Tech Stack:**
  - **Spring Boot:** For REST API development.
  - **MongoDB:** Database to store product details.
  - **Prometheus, Loki, Tempo:** For observability.
  - **TestContainers:** For integration testing with MongoDB.

### 2. **Order Service** 🛒
- **Description:** Manages customer orders in the system.
- **Features:**
  - **Place Order:** Allows customers to place orders.
  - **Kafka Integration:**
    - **Asynchronous Messaging:** Enables seamless communication between microservices by publishing order details to Kafka topics.
    - **Scalability:** Handles high-volume message flows for order processing and inventory updates.
    - **Fault Tolerance:** Ensures reliable message delivery and processing through Kafka's distributed architecture.
    - **Real-Time Updates:** Enables real-time synchronization of inventory and order statuses.
- **Observability Enhancements:**
  - Configured **Prometheus** for monitoring metrics 📈.
  - Added **Loki** for logging and **Tempo** for tracing.
- **Tech Stack:**
  - **Spring Boot:** For REST API development.
  - **MySQL:** Database to store order details.
  - **Flyway:** For database schema versioning and migrations.
  - **Kafka:** For asynchronous messaging.
  - **Prometheus, Loki, Tempo:** For observability.

### 3. **Inventory Service** 📋
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

### 4. **API Gateway** 🔗
- **Description:** Acts as a single entry point for all microservices, providing routing, authentication, fault tolerance, and observability.
- **Features:**
  - **Swagger Aggregation:** Aggregates API documentation from all microservices.
  - **Resilience4J Circuit Breaker:** Adds fault tolerance for service communication.
  - **OAuth2 Security:** Configured authentication using Keycloak with JWT tokens 🔐.
  - **CORS Configuration:** Configured to allow requests from frontend applications.
  - **Observability Enhancements:**
    - Integrated **Prometheus** for monitoring API metrics.
    - Configured **Grafana** dashboards for visualization 📊.
    - Set up **Tempo** for distributed tracing.
    - Added **Loki** for centralized logging.
  - **Keycloak Realm Configuration:** Exported Keycloak client configurations for streamlined authentication setup.
- **Tech Stack:**
  - **Spring Boot:** For API gateway development.
  - **Keycloak:** For authentication and authorization.
  - **Resilience4J:** For circuit breaker implementation.
  - **Prometheus, Grafana, Tempo, Loki:** For observability.

### 5. **Notification Service** ✉️
- **Description:** Handles customer notifications for order-related events.
- **Features:**
  - **Order Confirmation Emails:** Sends email notifications to customers upon successful order placement.
  - **Kafka Consumer:** Consumes order placement events from Kafka topics and triggers email notifications.
- **Tech Stack:**
  - **Spring Boot:** For service development.
  - **JavaMailSender:** For email functionality.
  - **Kafka:** For consuming order placement events asynchronously.
  - **MySQL:** (Optional) For storing notification logs or templates.

## Kubernetes Deployment 🌐

This project includes comprehensive Kubernetes deployment configurations for all services, providing a scalable and fault-tolerant infrastructure.

### Features:
- **Deployment Manifests:**
  - Each service is defined with its own Kubernetes deployment, service, and ConfigMap for environment-specific configurations.
- **Local Development with KinD:** 🛠
  - KinD (Kubernetes in Docker) setup for testing deployments in a local environment.
- **Database Configuration:**
  - **MySQL** and **MongoDB** deployed with Persistent Volume Claims (PVC) for data persistence.
- **Observability Stack:**
  - Integrated **Prometheus**, **Grafana**, **Loki**, and **Tempo** for monitoring, logging, and tracing.
- **Kafka and Schema Registry:**
  - Kafka broker and Schema Registry setup for asynchronous message communication.
- **Security:**
  - Configured **Keycloak** for authentication and authorization.

### Deployment Steps:
1. **Setup Kubernetes Cluster:**
  - Use the provided `create-kind-cluster.sh` script to set up a KinD cluster.
2. **Apply Manifests:**
  - Navigate to `k8s/manifests` and apply all deployment and service manifests:
    ```bash
    kubectl apply -f infrastructure/
    kubectl apply -f applications/
    ```
3. **Verify Deployment:**
  - Check the status of pods and services:
    ```bash
    kubectl get pods
    kubectl get svc
    ```
4. **Port Forwarding (Optional):**
  - Access services locally using port forwarding:
    ```bash
    kubectl port-forward svc/api-gateway 9000:9000
    ```

## Technologies Used
- **Spring Boot:** For building microservices.
- **Flyway:** Database versioning for `order-service`.
- **MongoDB TestContainer:** For integration testing in `product-service`.
- **MySQL:** Database for `order-service` and `inventory-service`.
- **MongoDB:** Database for `product-service`.
- **Kafka:** For asynchronous communication.
- **Prometheus, Loki, Tempo:** For observability and monitoring.
- **Grafana:** For creating dashboards and visualizing system metrics.
- **Resilience4J:** Circuit breaker for fault-tolerant communication.
- **Keycloak:** For authentication and authorization in `api-gateway`.
- **JavaMailSender:** For email notifications in `notification-service`.
- **Kubernetes:** For deploying and managing services.
- **KinD:** For local Kubernetes cluster setup.
