# Student Record Storage System

## Overview

Student Record Storage System is a Java Swing desktop application for managing student records. It follows a layered architecture with separate UI, controller, service, repository, and model layers. The current implementation supports login, dashboard display, and file-based persistence for student data.

## Key Features

- Login screen with credential validation
- Dashboard frame with header panel
- Student data modeled in a `Student` entity
- File-based persistence using Java object serialization
- Reusable styled Swing components for fields and buttons

## Project Structure

- `src/app/Main.java` — application entry point
- `src/config/AppConfig.java` — app constants and window sizes
- `src/model/Student.java` — student data model
- `src/repository/StudentRepository.java` — persistence interface
- `src/repository/StudentRepositoryImpl.java` — file persistence implementation
- `src/service/StudentService.java` — business service interface
- `src/service/StudentServiceImpl.java` — student CRUD logic
- `src/controller/NavigationController.java` — card navigation controller
- `src/ui/LoginFrame.java` — login UI
- `src/ui/DashboardFrame.java` — dashboard UI
- `src/ui/panel/HeaderPanel.java` — header panel with clock
- `src/ui/component` — styled Swing components
- `src/util` — utility classes (placeholders)

## Usage

1. Run `src/app/Main.java`
2. Enter credentials:
   - Username: `admin`
   - Password: `admin123`
3. On successful login, the dashboard window opens.

## Persistence

Student data is stored in `student.ser` using Java serialization. The `StudentServiceImpl` loads students on startup and saves after add/update/delete operations.

## Notes

- The login check is hard-coded and not secure.
- `User`, `LoginController`, `StudentController`, `DashboardPanel`, and other UI panels are placeholders.
- Design is ready for expansion with full navigation and student management UI.

## Documentation

- See `docs/architecture.md` for architecture and diagrams.

## Future Improvements

- Add real login authentication with users
- Implement complete dashboard and student CRUD UI
- Replace file serialization with a database
- Use MVC wiring to connect controllers and views
