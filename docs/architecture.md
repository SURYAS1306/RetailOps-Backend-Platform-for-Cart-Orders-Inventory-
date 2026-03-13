# System Architecture

The RetailOps backend follows a layered architecture using Spring Boot.

```
Client (Postman / Web App)
        |
        v
   REST Controllers
        |
        v
     Services
 (Business Logic Layer)
        |
        v
   Repositories (JPA)
        |
        v
      Database
```

---

## Security Layer

Authentication and authorization are handled using **JWT tokens**.

```
Client Request
      |
      v
Security Filter Chain
      |
      v
JWT Authentication Filter
      |
      v
Controller
```

---

## Request Flow Example

Example: **Add product to cart**

```
Client Request
     |
     v
CartController
     |
     v
CartService
     |
     v
CartItemRepository
     |
     v
Database
```

---

## Inventory Update Flow

```
Order Checkout
      |
      v
InventoryService
      |
      v
ProductRepository
      |
      v
InventoryLogRepository
```

---

## Key Components

| Component | Purpose |
|----------|--------|
| Controller | Handle API requests |
| Service | Business logic |
| Repository | Database interaction |
| Security | Authentication & authorization |
| Entity | Database models |
| DTO | API response models |

---

## Technologies Used

- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- H2 Database
- Docker

---
