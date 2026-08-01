# 📦 PPC E-Commerce Order Microservice

[![Deploy to AWS ECS](https://github.com/PPC2001/ppc-ecommerce-order-service/actions/workflows/deploy-to-ecs.yml/badge.svg)](https://github.com/PPC2001/ppc-ecommerce-order-service/actions/workflows/deploy-to-ecs.yml)
[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Non--Root%20USER%20nobody-blue.svg)](https://www.docker.com/)

---

## 📌 Overview

**`ppc-ecommerce-order-service`** is the Order Processing REST microservice for the PPC E-Commerce ecosystem. Built with Java 21 and Spring Boot 3.4.2, it handles order lifecycle management and customer purchases.

---

## 🏗️ Architecture & SDK Integration

- **Port**: `8082` (Container exposed ports `8082` and `8080`)
- **Shared SDK**: Consumes [`ppc-ecommerce-common-sdk:1.0.1`](https://github.com/PPC2001/ppc-ecommerce-common-sdk) for domain models (`OrderDto`, `OrderCreatedEvent`, `ApiResponse<T>`).
- **Container Security**: Runs in Docker as a non-root user (`USER nobody`).

---

## 🚀 REST API Specification

### 1. Actuator Health Check
```http
GET /ppc-ecommerce-order-service/actuator/health
```

### 2. Get All Orders
```http
GET /ppc-ecommerce-order-service/api/v1/orders
```

### 3. Get Order by ID
```http
GET /ppc-ecommerce-order-service/api/v1/orders/{orderId}
```

### 4. Create New Order
```http
POST /ppc-ecommerce-order-service/api/v1/orders
Content-Type: application/json
```
```json
{
  "customerId": "CUST-501",
  "items": "PROD-001 x 2",
  "totalAmount": 399.98
}
```

---

## ☁️ AWS ECS Fargate Deployment & CI/CD

- **ECR Repository**: `ppc-ecommerce-order-service`
- **ECS Cluster**: `pratik-dev-cluster`
- **ECS Service**: `ppc-ecommerce-order-service-dev`
- **Target Group**: `ppc-order-tg-dev`
- **ALB Path**: `/ppc-ecommerce-order-service/*`
- **CloudWatch Log Group**: `/ecs/ppc-ecommerce-order-task-dev`

---

## 💻 Local Execution

```bash
mvn clean package --settings settings.xml
java -jar target/ppc-ecommerce-order-service-1.0.0.jar
```

Or run via Docker:
```bash
docker build -t ppc-ecommerce-order-service:latest .
docker run -p 8082:8082 ppc-ecommerce-order-service:latest
```
