# 🚀 Workforce Management Application Submission

## 📌 Project Name
Workforce Task Management API

## 🧑‍💻 Developed By
Prashanth Bonkuru

---

## 🔗 Submission Links

### 1. Link to your Public GitHub Repository
[https://github.com/Prashanth2Github/Workforce_Management](https://github.com/Prashanth2Github/Workforce_Management)

### 2. Link to your Video Demonstration
(Please ensure the link is publicly accessible)  
[https://www.loom.com/share/YOUR-LOOM-VIDEO-LINK-HERE](https://www.loom.com/share/11d5b7746b854aeb868a7e068c3a549f?sid=5ab5be1f-cb6e-4c20-bcac-2e5d4dec709f)

---

## ✅ Assignment Checklist

| Requirement | Status | Notes |
|-------------|--------|-------|
| Health check endpoint (`/task-mgmt/`) | ✅ Done | Returns running status |
| Create multiple tasks (`/create`) | ✅ Done | Validates and persists tasks |
| Update task status/description (`/update`) | ✅ Done | Handles multiple task updates |
| Assign task by reference (`/assign-by-ref`) | ✅ Done | Cancels existing and reassigns |
| Smart Daily View (`/fetch-by-date/v2`) | ✅ Done | Filters tasks based on deadline and completion |
| Get task by ID (`/{id}`) | ✅ Done | Returns task + activity history |
| Update task priority (`/update-priority`) | ✅ Done | Priority can be changed |
| Get by priority (`/priority/{priority}`) | ✅ Done | Fetch all by priority |
| Add a comment (`/comment`) | ✅ Done | Stores and logs comment activity |
| Validation | ✅ Done | Handles required fields and validation |
| Exception Handling | ✅ Done | Graceful errors with messages |
| H2 Console Enabled | ✅ Done | `/h2-console` for in-memory DB |
| Code Structure | ✅ Done | Follows MVC + DTO + Service + Repository pattern |
| Testing | ✅ Done | All API endpoints tested via Thunder Client |

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA (H2 in-memory DB)
- Lombok
- H2 Console
- Thunder Client (for testing)

---

## 🔄 How to Run

1. **Clone the repo**:
   ```bash
   git clone https://github.com/Prashanth2Github/Workforce_Management.git
   cd Workforce_Management
   ```

2. **Run the application using Gradle**:
   ```bash
   gradle clean bootRun
   ```

3. **Access the H2 Database Console**:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User: `sa`
   - Password: _(leave blank)_

4. **Test API Endpoints** using Thunder Client/Postman:
   - Health: `GET http://localhost:8080/task-mgmt/`
   - Create Task: `POST http://localhost:8080/task-mgmt/create`
   - Update Task: `POST http://localhost:8080/task-mgmt/update`
   - Assign by Reference: `POST http://localhost:8080/task-mgmt/assign-by-ref`
   - Fetch by Date: `POST http://localhost:8080/task-mgmt/fetch-by-date/v2`
   - Get by ID: `GET http://localhost:8080/task-mgmt/{id}`
   - Update Priority: `POST http://localhost:8080/task-mgmt/update-priority`
   - Get by Priority: `GET http://localhost:8080/task-mgmt/priority/{priority}`
   - Add Comment: `POST http://localhost:8080/task-mgmt/comment`

---

## 📂 File Structure

```
src/main/java/com/railse/hiring/workforcemgmt/
├── controller/              # REST controllers
├── dto/                     # DTOs for request/response
├── mapper/                  # DTO ↔ Entity mappers
├── model/                   # Entity + Enums + Activity/Comment
├── repository/              # Spring JPA Repositories
├── service/                 # Interfaces
├── service/impl/            # Service implementations
└── Application.java         # Main app
```

---

## 🛠️ Implemented Features

- All **mandatory features** completed
- All **bonus features** completed
- All bug fixes applied:
  - ✅ Fixed `assign-by-ref` to cancel previous tasks
  - ✅ Fixed `fetch-by-date` to exclude cancelled tasks
- Validation annotations & null checks in DTOs
- Exception handling for invalid input
- Activity history & comments stored in-memory

---

## 📌 Notes

- All functional tests passed using Thunder Client
- Robust error handling for invalid and missing parameters
- Fully structured MVC + DTO + Service + Repository architecture

---

## 🔚 Final Note

Thank you for the opportunity! Looking forward to your feedback.

---
