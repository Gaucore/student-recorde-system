# Student Record Storage System

## Overview

Student Record Storage System is a Java Swing desktop application for managing student records. The current version uses a layered structure with UI, controller, service, repository, and model classes. It includes a login screen flow, a dashboard shell, and file-based persistence for student data.

## Current Features

- Login window UI with username and password fields
- Authentication flow through controller and service classes
- Dashboard window with a header panel and live clock
- Student CRUD service logic with persistence support
- File-based storage using Java serialization in `data/student.dat`
- Reusable Swing UI components for a more polished desktop experience

## Project Structure

- `src/app/Main.java` — application entry point
- `src/config/AppConfig.java` — shared app constants and sizing values
- `src/controller/LoginController.java` — login request handling
- `src/controller/NavigationController.java` — navigation placeholder for future UI cards
- `src/model/Student.java` — student entity model
- `src/model/User.java` — user model used by authentication
- `src/repository/UserRepository.java` — temporary user lookup implementation
- `src/repository/StudentRepository.java` — file-based student persistence and student lookup
- `src/service/AuthenticationService.java` — authentication logic
- `src/service/StudentService.java` — student CRUD validation and service layer implementation
- `src/ui/LoginFrame.java` — login UI screen
- `src/ui/DashboardFrame.java` — main dashboard window shell
- `src/ui/panel/HeaderPanel.java` — header panel with clock and welcome content

## How to Run

1. Run `src/app/Main.java` from your Java IDE.
2. Use the default login credentials:
   - Username: `admin`
   - Password: `admin123`
3. After a successful login, the dashboard window opens.

## Application Flow

1. `Main` launches the login screen.
2. `LoginFrame` collects the entered credentials.
3. `LoginController` passes the request to `AuthenticationService`.
4. `UserRepository` verifies the known admin account.
5. On success, the dashboard opens and the app moves into the main desktop shell.
7. `StudentService` manages student records and persists them through `StudentRepository`.

## Persistence

Student data is stored in `student.ser` using Java object serialization. The service loads the list on startup and saves it after add, update, or delete operations.

## Documentation

- `docs/architecture.md` — layered architecture and component overview
- `docs/flow.md` — updated runtime flow and sequence diagrams

## Notes

- Authentication is currently a simple hard-coded admin check and is not yet a secure production solution.
- The dashboard is still a shell, and future work can extend it with full student management panels and richer navigation.
<img width="1387" height="851" alt="image" src="https://github.com/user-attachments/assets/915e4eb7-fe35-42e7-b0af-6ded17bb1654" /><br>
<img width="1382" height="835" alt="image" src="https://github.com/user-attachments/assets/797c3c27-7aae-461d-950e-ce130e26140b" /><br>
<img width="1378" height="851" alt="image" src="https://github.com/user-attachments/assets/e4f90bef-a10f-4f4d-965d-1c8cf8392b83" />



