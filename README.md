# Workforce Management System

A Spring Boot-based RESTful API to manage workforce tasks such as assignment, prioritization, tracking, and commenting. This system supports various task types like order fulfillment, entity handling, and user assignments.

## ✅ Features Implemented

- Task creation with reference details
- Reassignment and task status management
- Smart daily view with date-range filters
- Priority updates and filtering
- Comments and activity logs on tasks
- API endpoints covered with proper request/response formats

## 📁 Folder Structure

```
workforcemgmt/
├── build.gradle
├── settings.gradle
├── README.md
├── SUBMISSION.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/railse/hiring/workforcemgmt/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── service/impl/
│   │   └── resources/
│   │       └── application.yml
```

## 🔧 Tech Stack

- Java 17
- Spring Boot 3.x
- H2 In-Memory Database
- Gradle
- Lombok
- Jackson for JSON Mapping

## 🚀 How to Run the Application

1. Clone or download the project.
2. Open in any Java IDE (IntelliJ, Eclipse) or use terminal.
3. Run the application:

```bash
gradle clean bootRun
```

4. Open browser: [http://localhost:8080/task-mgmt/](http://localhost:8080/task-mgmt/)

## 📫 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /task-mgmt/ | Health check |
| POST   | /task-mgmt/create | Create new tasks |
| POST   | /task-mgmt/update | Update tasks (status/description) |
| POST   | /task-mgmt/assign-by-ref | Reassign based on reference |
| POST   | /task-mgmt/fetch-by-date/v2 | Get tasks by date and assignee |
| POST   | /task-mgmt/update-priority | Update task priority |
| GET    | /task-mgmt/priority/{priority} | Get tasks by priority |
| GET    | /task-mgmt/{id} | Get task details |
| POST   | /task-mgmt/comment | Add comment to task |

## 🧪 Sample Task Creation JSON

```json
{
  "tasks": [
    {
      "referenceId": 101,
      "referenceType": "ORDER",
      "task": "CREATE_INVOICE",
      "description": "Send invoice to customer",
      "status": "ASSIGNED",
      "assigneeId": 1,
      "taskDeadlineTime": 1754252007418,
      "priority": "HIGH"
    }
  ]
}
```

## 📌 Notes

- All timestamps are in epoch milliseconds.
- Tasks default to "ASSIGNED" status unless specified.
- Comments and activity logs are maintained in-memory.

## 👨‍💻 Author

- GitHub: [Prashanth2GitHub]
- Email: [bonkuruprashanth05@gmail.com]

## 📄 License

This project is for demo purposes only.