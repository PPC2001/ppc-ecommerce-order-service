# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]
### Added
### Changed
### Fixed

## [1.0.0] - 2026-07-31
### Added
- Initial release of Order Processing REST Microservice (`ppc-ecommerce-order-service`).
- Order Processing REST APIs: `GET /api/v1/orders`, `GET /api/v1/orders/{id}`, `POST /api/v1/orders`.
- Spring Boot Actuator ALB Health Check endpoint (`/actuator/health`).
- Integrated `ppc-ecommerce-common-sdk` version `1.0.0`.
- Infrastructure as Code (.iac): `tfvars.dev.json`, `tfvars.prod.json` (Fargate Spot 80/20 cost optimization), `local.tf`, `task-definition-template.json`, and SQS sidecar `resources.yml`.
- GitHub Actions CI/CD deployment pipeline (`deploy-to-ecs.yml`).
