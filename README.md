# RetailOps Backend Platform

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Docker](https://img.shields.io/badge/Docker-enabled-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

A scalable backend platform for **Cart, Orders, and Inventory Management** built using **Spring Boot**.

This project demonstrates a **production-style backend architecture** with authentication, inventory management, admin analytics, and Docker deployment.

---

# Features

- JWT Authentication
- Role-Based Access Control
- Product Catalog Management
- Cart Management
- Order Processing
- Inventory Management
- Admin Dashboard APIs
- Pagination & Sorting APIs
- Product Search API
- Inventory Audit Logging
- API Rate Limiting
- Swagger API Documentation
- Docker Deployment Support

---

# Tech Stack

| Technology | Purpose |
|------------|--------|
| Java 17 | Backend language |
| Spring Boot | Application framework |
| Spring Security | Authentication & authorization |
| JWT | Token-based security |
| Spring Data JPA | Database ORM |
| H2 Database | Development database |
| Maven | Dependency management |
| Docker | Containerization |

---

# Project Structure

```
src/main/java/com/retailops

config          Security & Swagger configuration
controller      REST API controllers
dto             Data Transfer Objects
entity          Database entities
repository      JPA repositories
security        JWT & rate limiting filters
service         Business logic
```

---

# API Endpoints

## Product APIs

| Method | Endpoint | Description |
|------|---------|-------------|
| GET | `/products` | Get all products |
| GET | `/products/search` | Search products |
| GET | `/products/low-stock` | Low stock products |
| POST | `/products` | Create product |

---

## Cart APIs

| Method | Endpoint |
|------|---------|
| GET | `/cart` |
| POST | `/cart/add` |
| DELETE | `/cart/remove` |

---

## Order APIs

| Method | Endpoint |
|------|---------|
| POST | `/orders/checkout` |
| GET | `/orders` |

---

## Admin APIs

| Method | Endpoint |
|------|---------|
| GET | `/admin/stats/orders` |
| GET | `/admin/stats/products` |
| GET | `/admin/stats/revenue` |

---

# Run Locally

### Build Project

```bash
mvn clean package
```

### Run Application

```bash
mvn spring-boot:run
```

Application runs at:

```
http://localhost:8080
```

---

# Run with Docker

```bash
docker-compose up --build
```

---

# API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

# Future Improvements

- Payment integration
- Redis caching
- Kafka event processing
- PostgreSQL production database
- CI/CD pipeline

---

# Author

**Surya Srinivasan**  
Computer Science Engineering  
VIT Vellore
