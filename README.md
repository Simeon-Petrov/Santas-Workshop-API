Santa's Workshop API
Project Overview
This is a RESTful API application built using Spring Boot designed to manage Santa's holiday operations. The system handles the lifecycle of Christmas gifts, coordinates elf assignments based on skill levels, and manages complex delivery logistics, including real-time status updates and delivery tracking.

Key Features Implemented
Gift Lifecycle Management: Supports full CRUD operations and a dedicated wrapping workflow that transitions gifts from PENDING to READY status.

Dynamic Elf Assignment: Assigns gifts to specific elves while validating gift availability and preventing the reassignment of already delivered items.

Delivery Logistics: Groups multiple gifts into a single delivery plan with automated status propagation (marking a delivery as DELIVERED automatically updates all associated gifts).

Real-time Statistics: Provides a dashboard endpoint to track workshop productivity, including gift counts by status and total successful deliveries.

Advanced Validation: Includes custom logic to prevent invalid state transitions (e.g., moving a gift from DELIVERED back to READY).

Global Error Handling: Centralized exception handling to return meaningful API errors (404 for missing resources, 409 for logical conflicts).
Category,Technology,Version / Role
Backend,Java Development Kit (JDK),17+
Framework,Spring Boot,3.x
API Type,REST,Controller-Service-Repository Pattern
Data Tools,Lombok,"Boilerplate reduction (Data, Builder)"
Validation,Jakarta Validation,Input constraints and DTO validation
Data,Jackson,JSON serialization/deserialization
