# Santa's Workshop API

## Project Overview

This is a **RESTful API application** built using **Spring Boot** designed to manage Santa's holiday operations. 
The system handles the lifecycle of Christmas gifts, coordinates elf assignments based on skill levels, and manages complex delivery logistics, including real-time status updates and delivery tracking.

---

## Key Features Implemented

- **Gift Lifecycle Management:** Supports full CRUD operations and a dedicated wrapping workflow that transitions gifts from `PENDING` to `READY` status.

- **Dynamic Elf Assignment:** Assigns gifts to specific elves while validating gift availability and preventing the reassignment of already delivered items.

- **Delivery Logistics:** Groups multiple gifts into a single delivery plan with automated status propagation (marking a delivery as `DELIVERED` automatically updates all associated gifts).

- **Real-time Statistics:** Provides a dashboard endpoint to track workshop productivity, including gift counts by status and total successful deliveries.

- **Advanced Validation:** Includes custom logic to prevent invalid state transitions (e.g., moving a gift from `DELIVERED` back to `READY`).

- **Global Error Handling:** Centralized exception handling to return meaningful API errors (404 for missing resources, 409 for logical conflicts).

---

## Technologies Used

| Category     | Technology               | Version / Role |
|--------------|--------------------------|----------------|
| **Backend** | Java Development Kit (JDK)| 17+ |
| **Framework**| Spring Boot              | 3+ |
| **API Type** | REST                     | Controller-Service-Repository Pattern |
| **Data Tools**| Lombok                  | Boilerplate reduction (Data, Builder) |
| **Validation**| Jakarta Validation      | Input constraints and DTO validation |
| **Data** | Jackson                  | JSON serialization/deserialization |

---

## Getting Started

Follow these steps to get the application up and running locally.

### 1. Prerequisites

Make sure you have the following installed on your machine:

- **Java Development Kit (JDK):** Version 17 or later  
- **Apache Maven:** Installed, or use an IDE with built-in Maven support

---

### 2. Build and Run

#### Step 1: Navigate to the project root (where `pom.xml` is located):

```bash
# Clone the project from your repository
git clone [https://github.com/Simeon-Petrov/Santas-Workshop-API.git](https://github.com/Simeon-Petrov/Santas-Workshop-API.git)
