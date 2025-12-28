# Cab Booking Application - Microservices

This project is a cab booking application built with a microservices architecture using Spring Boot and Spring Cloud.

## Architecture Overview

The application is divided into several independent services that work together to provide the full functionality. This architecture improves scalability, maintainability, and resilience.

### Key Components:

*   **Service Registry (Eureka):** A central server where all microservices register themselves. This allows services to discover and communicate with each other dynamically.
*   **API Gateway (Spring Cloud Gateway):** The single entry point for all client requests. It routes requests to the appropriate microservice and can handle cross-cutting concerns like authentication and rate limiting.
*   **User Service:** Manages user and driver registration and profiles.
*   **(Future) Auth Service:** Will handle user and driver authentication and session management.
*   **(Future) Booking Service:** Will manage the core booking logic, including finding rides and creating bookings.

---

## Modules

### 1. `service-registry`

*   **Purpose:** The Eureka server for service discovery.
*   **Port:** `8761`

### 2. `api-gateway`

*   **Purpose:** Routes all incoming traffic to the correct microservice.
*   **Port:** `8888`

### 3. `user-service`

*   **Purpose:** Handles all user and driver-related operations.
*   **Responsibilities:**
    *   User registration (`POST /api/users/register`)
    *   Driver registration (`POST /api/drivers/register`)
*   **Port:** `8081`

---

## How to Run the Application

To run the application, you need to start the services in a specific order. Ensure you have Java 17 and Maven installed.

### 1. Start the Service Registry

Open a terminal and navigate to the `service-registry` directory:

```bash
cd CabBookingMicroservices/service-registry
mvn spring-boot:run
```

Wait for it to start up. You can view the Eureka dashboard at `http://localhost:8761`.

### 2. Start the User Service

Open a new terminal and navigate to the `user-service` directory:

```bash
cd CabBookingMicroservices/user-service
mvn spring-boot:run
```

Wait for it to start and confirm that it registers with the Eureka server on the dashboard.

### 3. Start the API Gateway

Open a third terminal and navigate to the `api-gateway` directory:

```bash
cd CabBookingMicroservices/api-gateway
mvn spring-boot:run
```

The application is now running. All requests should be made through the API Gateway at `http://localhost:8888`.

---

## Example API Calls

### Register a User

*   **URL:** `http://localhost:8888/api/users/register`
*   **Method:** `POST`
*   **Body:**
    ```json
    {
        "username": "jules",
        "password": "password123",
        "email": "jules@example.com",
        "mobileNumber": "1234567890",
        "currentPosition": [1, 1]
    }
    ```

### Register a Driver

*   **URL:** `http://localhost:8888/api/drivers/register`
*   **Method:** `POST`
*   **Body:**
    ```json
    {
        "username": "driver_jules",
        "password": "password123",
        "mobileNumber": "0987654321",
        "licenseNumber": "ABC-123",
        "currentPosition": [2, 2],
        "numberPlate": "XYZ-789"
    }
    ```

---

## Tech Stack

*   **Java 17**
*   **Spring Boot 2.7.5**
*   **Spring Cloud 2021.0.5**
*   **Spring Cloud Gateway**
*   **Netflix Eureka**
*   **Spring Data JPA**
*   **Hibernate**
*   **MySQL**
*   **Maven**
