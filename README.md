# Welcome to EDMIS (Education Data Management & Information System)

## 🏗️ Project Overview

This project is a full-stack web application designed to manage internal student, class, and subject data for a college. It leverages modern technologies and follows accessibility and API best practices.

---

### 🖥️ Frontend

- **Framework**: [React](https://reactjs.org/)
- **Design System**: [U.S. Web Design System (USWDS)](https://designsystem.digital.gov/)
  - Ensures **Section 508** compliance for accessible interfaces
- **Package Manager**: `npm` / `yarn`
- **Component Architecture**: Modular and scalable with reusable form components
- **State Management**: [Redux Toolkit](https://redux-toolkit.js.org/)
- **Routing**: [React Router](https://reactrouter.com/)

---

### ⚙️ Backend

- **Framework**: [Spring Boot](https://spring.io/projects/spring-boot)
- **Language**: Java
- **Build Tool**: Maven
- **API Testing & Documentation**: Integrated with [Swagger UI](https://swagger.io/tools/swagger-ui/)
  - Provides an interactive interface for testing and validating REST endpoints

---

### 📦 API Documentation

Once the backend server is running, Swagger UI is available at: [Swagger](http://localhost:8080/swagger-ui/index.html#//)

## 🛠️ Local Development

Set up the backend and frontend in separate terminals for local development.

---

### ▶️ Backend (Spring Boot)

```bash
cd ~/EDMIS/edmis-app-backend/
./mvnw spring-boot:run
```

- Runs on: http://localhost:8080
- Tools:
  - Swagger UI: API documentation & testing
  - H2 Console: In-memory DB browser

### ▶️ Frontend (React)

```bash
`cd ~/IdeaProjects/EDMIS/edmis-app-frontend/`
`npm ci`
`npm dev`
```

- Runs on: http://localhost:5173
- Framework: React (with USWDS components)
- Port: 5173 (default for Vite

### links:

- UI: http://localhost:5173/
- Swagger: http://localhost:8080/swagger-ui/index.html#/
- DB Console: http://localhost:8080/console/login.do?jsessionid=8e28f5af4456fa062ede2aa891fc9aa3
