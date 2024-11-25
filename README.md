# Hospital Management System API

## Overview
This project is a **Hospital Management System API** built with **Spring Boot**. The API provides operations for managing patients, doctors, appointments, departments, and staff, utilizing the **H2 in-memory database** for testing and development.

---

## Features
- CRUD operations for:
  - Patients
  - Doctors
  - Appointments
  - Departments
  - Staff
- Entity relationships:
  - Many-to-one between Appointments and Patients.
  - Many-to-one between Appointments and Doctors.
  - One-to-many between Departments and Staff.

---

## Technologies Used
- **Spring Boot** (Framework)
- **Spring Web** (RESTful APIs)
- **Spring Data JPA** (Database interaction)
- **H2 Database** (In-memory database for testing)

---

## Getting Started

### Prerequisites
- Java 17 or later
- Maven

### Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/hospital-management-api.git
   cd hospital-management-api
