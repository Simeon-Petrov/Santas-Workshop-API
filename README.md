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

### 3. Access the Application

Once the application starts (typically runs on port **8080**), open your browser or Postman and go to:

[http://localhost:8080/api](http://localhost:8080/api)

---

## Code Highlights

| Feature | File / Location | Implementation Detail |
|---------|-----------------|-----------------------|
| **Status Propagation** | `DeliveryService.java` | Automatically updates all linked `Gift` entities to `DELIVERED` when the parent delivery status is updated. |
| **Conflict Handling** | `ElfService.java` | Validates gift status before assignment, throwing `IllegalStateException` to trigger a 409 Conflict response. |
| **Custom Deserialization** | `Status.java` | Uses `@JsonCreator` to handle case-insensitive string-to-enum conversion for API requests. |
| **Automated ID Generation** | `All Services` | Uses `AtomicLong` to manage unique identifiers for in-memory data storage. |
| **Filtering Logic** | `GiftService.java` | Implements Java Streams to filter gifts dynamically by status or category via request parameters. |

---

## API Documentation

You can find detailed API request examples and test scenarios in the following file:

- [Test Requests (HTTP Client)](test_requests.http)

---

## Author

**Simeon Petrov**
