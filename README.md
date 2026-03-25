# Overview

A RESTful API built with Java and Spring Boot that allows users to track expenses, categorize spending, and manage financial data.

## Features
### User management (CRUD)<br>
Expense tracking per user<br>
Category-based expense organization<br>
DTO-based API responses (secure and clean)<br>
H2 in-memory database for development<br>
### Tech Stack<br>
Java 17<br>
Spring Boot<br>
Spring Data JPA<br>
H2 Database<br>
Maven<br>
## API Endpoints
### Users
GET /users<br>
GET /users/{id}<br>
POST /users<br>
### Expenses<br>
GET /expenses<br>
GET /expenses/user/{userId}<br>
POST /expenses<br>
DELETE /expenses/{id}<br>
### Categories<br>
GET /categories<br>
POST /categories<br>
## How to Run<br>
./mvnw spring-boot:run<br>

### Then visit: 
http://localhost:8080<br>
## Future Improvements<br>
Budget tracking per category<br>
PostgreSQL integration<br>
Authentication & authorization (JWT)<br>
Frontend UI (React)<br>
## Author<br>
Connor McDevitt<br>