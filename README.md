# 📦 `ppc-ecommerce-order-service`

Order Processing REST Microservice for PPC E-Commerce Ecosystem.

## 📌 Features
- Order Processing REST APIs (`GET /api/v1/orders`, `POST /api/v1/orders`)
- Spring Boot 3.4.2 & Java 21
- Lombok & Spring Boot Actuator (`/actuator/health`)
- Consumes `ppc-ecommerce-common-sdk` DTOs

## ⚙️ Configuration
Dynamic placeholders in `application.properties`:
- Port: `${PORT:8082}`
- Profile: `${SPRING_PROFILES_ACTIVE:dev}`

## 🛠️ Local Run
```bash
mvn spring-boot:run
```
