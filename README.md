# Microservices Template for Spring MVC

## 🚀 Overview
This project provides a template for building microservices using Spring MVC on a Kind multi-node Kubernetes cluster.

<details>
<summary><h2>🎯 Main Functionality</h2></summary>

-  Microservices architecture with Spring MVC (with potential for ReactiveWeb services)
-  Deployment on Kind multi-node cluster
-  API Gateway for routing and security
-  OAuth2 authentication using Keycloak
-  Inter-service communication
-  Particialy event-driven architecture using Kafka
-  Notification service with smtp
-  Monitoring and observability (planned)
</details>

<details>
<summary><h2>🛠 Current Implementation</h2></summary>

### Service Discovery
-  Migrated from Eureka to Kubernetes native discovery

### API Gateway
-  Using Spring WebFlux gateway
-  Connects to Keycloak for authentication

### Authentication
-  Keycloak (OAuth2) with a simple realm
-  Resource server configuration
-  TODO: Resolve JWT issuer problems with Ingress for Keycloak realm

<!-- Остальное содержимое текущей реализации -->

</details>

<details>
<summary><h2> Planned additions </h2></summary>

1.  Add support for ReactiveWeb services
2.  Optimize build process by abandoning multi-module structure for faster deployment
3.  Provide option for Gradle as an alternative build tool
4.  Implement RestTemplate as the primary inter-service communication method
5.  Add Prometheus and Grafana for monitoring and observability
6.  Resolve JWT issuer configuration for Keycloak in Kubernetes environment
7.  Consider removing the common module for simplified architecture
8.  Evaluate the need for multi-module project structure

</details>

##  Target Audience

This system is designed for developers who want to start working with backend microservices architecture.

## Current working Branch : kubernetes
