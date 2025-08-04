# Workforce Management System

A Spring Boot-based RESTful API to manage workforce tasks such as assignment, prioritization, tracking, and commenting. 
This system allows creation, reassignment, priority management, date-range fetching, and commenting on tasks.

---

## ✅ Features Implemented

- **Health Check Endpoint** - Verify API status
- **Create Tasks** - Add one or multiple tasks with details
- **Assign Task by Reference** - Reassign work and cancel old tasks
- **Get Task by ID** - Fetch task details with current status
- **Get Tasks by Priority** - Filter tasks based on priority
- **Add Comment to Task** - Append notes to tasks
- **Update Task Priority** - Change priority dynamically
- **Fetch Tasks by Date** - Smart daily view with active and pending tasks

---

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
│   │       └── application.properties
```

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** with H2 In-Memory Database
- **Gradle** for build automation
- **Lombok** for boilerplate code reduction
- **Jackson** for JSON processing

---

## 🚀 How to Run the Application

1. Clone or download the project.
2. Open the project in an IDE (IntelliJ, Eclipse) or terminal.
3. Run the application:

```bash
gradle clean bootRun
```

4. Test the endpoints using **Thunder Client** or **Postman**.

---

## 📫 API Endpoints and Example Requests/Responses

### **1. Health Check**
**GET** `http://localhost:8080/task-mgmt/`

_Response:_
```json
{
  "data": "✅ Workforce Management API is running.",
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **2. Create Task**
**POST** `http://localhost:8080/task-mgmt/create`

_Request:_
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

_Response:_
```json
{
  "data": [
    {
      "id": 5,
      "reference_id": 101,
      "reference_type": "ORDER",
      "task": "CREATE_INVOICE",
      "description": "Send invoice to customer",
      "status": "ASSIGNED",
      "assignee_id": 1,
      "task_deadline_time": 1754252007418,
      "priority": "HIGH"
    }
  ],
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **3. Assign Task by Reference**
**POST** `http://localhost:8080/task-mgmt/assign-by-ref`

_Request:_
```json
{
  "referenceId": 101,
  "referenceType": "ORDER",
  "assigneeId": 2
}
```

_Response:_
```json
{
  "data": "Reassignment completed. Old tasks cancelled.",
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **4. Get Task by ID**
**GET** `http://localhost:8080/task-mgmt/1`

_Response:_
```json
{
  "data": {
    "id": 1,
    "reference_id": 101,
    "reference_type": "ORDER",
    "task": "CREATE_INVOICE",
    "description": "Seeded task",
    "status": "CANCELLED",
    "assignee_id": 1,
    "task_deadline_time": 1754373772518,
    "priority": "HIGH"
  },
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **5. Get Tasks by Priority**
**GET** `http://localhost:8080/task-mgmt/priority/HIGH`

_Response:_
```json
{
  "data": [
    {
      "id": 1,
      "reference_id": 101,
      "reference_type": "ORDER",
      "task": "CREATE_INVOICE",
      "description": "Seeded task",
      "status": "CANCELLED",
      "assignee_id": 1,
      "task_deadline_time": 1754373772518,
      "priority": "HIGH"
    },
    {
      "id": 5,
      "reference_id": 101,
      "reference_type": "ORDER",
      "task": "CREATE_INVOICE",
      "description": "Send invoice to customer",
      "status": "CANCELLED",
      "assignee_id": 1,
      "task_deadline_time": 1754252007418,
      "priority": "HIGH"
    }
  ],
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **6. Add Comment to Task**
**POST** `http://localhost:8080/task-mgmt/comment?taskId=1&comment=Urgent follow-up needed`

_Response:_
```json
{
  "data": "Comment added.",
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **7. Update Task Priority**
**POST** `http://localhost:8080/task-mgmt/update-priority`

_Request:_
```json
{
  "task_id": 1,
  "priority": "LOW"
}
```

_Response:_
```json
{
  "data": {
    "id": 1,
    "reference_id": 101,
    "reference_type": "ORDER",
    "task": "CREATE_INVOICE",
    "description": "Seeded task",
    "status": "CANCELLED",
    "assignee_id": 1,
    "task_deadline_time": 1754373772518,
    "priority": "LOW"
  },
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

### **8. Fetch Tasks by Date**
**POST** `http://localhost:8080/task-mgmt/fetch-by-date/v2`

_Request:_
```json
{
  "start_date": 1754252007000,
  "end_date": 1754338407000,
  "assignee_ids": [1, 2]
}
```

_Response:_
```json
{
  "data": [],
  "pagination": null,
  "status": {
    "code": 200,
    "message": "Success"
  }
}
```

---

## 📌 Notes

- All timestamps are **epoch milliseconds**.
- The API uses **H2 in-memory database**, so data resets after application restart.
- Designed with **MVC + DTO + Service + Repository** architecture.

## 👨‍💻 Author

- GitHub: [Prashanth2GitHub](https://github.com/Prashanth2Github)
- Email: bonkuruprashanth05@gmail.com
