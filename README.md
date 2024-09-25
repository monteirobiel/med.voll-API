# API REST com Spring Boot e Spring Security usando JWT(Auth0)

This is a REST API project that simulates the functioning of a medical clinic, with CRUD operations to manage doctors and patients. The system includes classes that represent these users, and both have logins and specific functionalities according to their profiles. It was developed in Java, using Spring Boot and Spring Security, with stateless authentication and authorization through JWT.
## Table of Contents

- [Features](#Features)
- [Requirements](#Requirements)
- [Execution](#Execution)
- [API Endpoints](#API-Endpoints)
- [Database](#Database)

# Features
- Implementation of authentication/authorization with Spring Security (JWT)
- CRUD operations such as registering a new doctor or patient, updating data, among others.
# Requirements
- Java 17 +
- Maven
- MySQL (configurable in the `application.properties` file)
- Preferred tool for testing endpoints.
# Execution
1. Clone the repository:

```
git clone https://github.com/monteirobiel/med.voll-API.git
```

2. Navigate to the project directory:

```
cd med.voll-AP
```

3. Run the application using Maven:

```
mvn spring-boot:run
```
4. You can access the API through `http://localhost:8080`.

# API Endpoints
## Login

- **POST** `/login`
- Request body for operation:
```json
{
"username": "patient's cpf or doctor's crm",
"password": "password"
}
```
- Returns a valid JWT token for future authentications.

## Restricted access for Doctors

- **GET** `/doctors`
- Returns specific information for users of the **Doctor** type.
- **POST** `/doctors`
- Records information of the **Doctor** type.
- **PUT** `/doctors`
- Request body for operation:
```json
{
"id": "doctor's id",
"phone": "doctor's phone"
}
```
Updates information of the **Doctor** type.

- **DELETE** `/patients`
- Deactivates the **Doctor** type registration.

## Restricted access for Patients

- **GET** `/patients`
- Returns specific information for **Patient** type users.

- **POST** `/patients`
- Registers the **Patient** type information.

- **PUT** `/patients`
- Request body for operation:
```json
{
"id": "patient id",
"phone": "patient phone number"
}
```
Updates **Patient** type information.

- **DELETE** `/patients`
- Deactivates **Patient** type registration.
## Database

The database structure will be created automatically by Flyway, according to the migrations located in `src/main/resources/db/migration`.

For testing purposes, access the database and execute the following SQL commands:
```
insert into users(id, username, password) values(1, '00011122233', '$2a$10$1g.8vUZgxS10V0FcORrGyOUTFroyioIPHyGSZWSQSNfe.DNQdU19C');
insert into patients(id, name, email, cpf) values(1, 'Paciente beltrana', 'paciente@email.com.br', '00011122233');

insert into users(id, username, password) values(2, '112233', '$2a$10$1g.8vUZgxS10V0FcORrGyOUTFroyioIPHyGSZWSQSNfe.DNQdU19C');
insert into doctors(id, name, email, crm) values(2, 'Medico fulano', 'medico@email.com.br', '112233');
```

A doctor with CRM (username): **112233** and password **123456** will be entered. A patient with CPF (username): **00011122233** and password **123456** will also be entered.
