# RetailOps Backend Platform

A scalable backend platform for **Cart, Orders, and Inventory management** built using **Spring Boot**.

---

## Features

- JWT Authentication & Role-Based Access Control
- Product Catalog Management
- Cart Management System
- Order Processing
- Inventory Stock Management
- Admin Dashboard APIs
- Pagination, Sorting, and Search APIs
- Inventory Audit Logging
- API Rate Limiting
- Swagger API Documentation
- Docker Deployment Support

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- H2 Database
- Docker
- Maven

---

## Project Structure

```
src/main/java/com/retailops

config          # Security and Swagger configuration
controller      # REST API controllers
dto             # Data Transfer Objects
entity          # JPA entities
repository      # Database repositories
security        # JWT & rate limiting filters
service         # Business logic layer
```

---

## API Endpoints

### Product APIs

```
GET /products
GET /products/search?keyword=laptop
GET /products/low-stock
POST /products
```

### Cart APIs

```
GET /cart
POST /cart/add
DELETE /cart/remove
```

### Order APIs

```
POST /orders/checkout
GET /orders
```

### Admin APIs

```
GET /admin/stats/orders
GET /admin/stats/products
GET /admin/stats/revenue
```

---

## Run Locally

### Build Project

```bash
mvn clean package
```

### Run Application

```bash
mvn spring-boot:run
```

---

## Run with Docker

Build and run the backend container:

```bash
docker-compose up --build
```

Application will run at:

```
http://localhost:8080
```

---

## API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Author

**Surya Srinivasan**

Computer Science Engineering  
VIT Vellore
