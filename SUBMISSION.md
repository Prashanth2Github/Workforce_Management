
# 🚀 Workforce Management Application Submission

## 📌 Project Name
Workforce Task Management API

## 🧑‍💻 Developed By
Prashanth Bonkuru

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

1. Clone the repo or extract the codebase to a local folder.
2. Navigate into the project directory:
   ```bash
   cd workforcemgmt
   ```
3. Run the application using Gradle:
   ```bash
   gradle clean bootRun
   ```
4. Access the H2 DB Console:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User: `sa`
   - Password: _(leave blank)_

5. Access the API:
   - Health: `http://localhost:8080/task-mgmt/`
   - Use Thunder Client/Postman for all endpoints

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

## 📎 Notes

- All mandatory and bonus features implemented successfully.
- All functional tests passed (via Thunder Client).
- Bug Fixes included:
  - ✅ assign-by-ref null check
  - ✅ fetch-by-date priority and deadline filter fixed
- Validation annotations and null checks added to DTOs.
- Robust error handling added for invalid input and not found.

---

## 🔚 Final Note

Thank you for the opportunity! Looking forward to your feedback.
