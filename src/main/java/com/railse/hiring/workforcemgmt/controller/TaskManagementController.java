package com.railse.hiring.workforcemgmt.controller;

import com.railse.hiring.workforcemgmt.dto.*;
import com.railse.hiring.workforcemgmt.response.Response;
import com.railse.hiring.workforcemgmt.service.TaskManagementService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-mgmt")
public class TaskManagementController {

    private final TaskManagementService taskManagementService;

    public TaskManagementController(TaskManagementService taskManagementService) {
        this.taskManagementService = taskManagementService;
    }

    // ✅ Root health check
    @GetMapping("/")
    public Response<String> healthCheck() {
        return new Response<>("✅ Workforce Management API is running.");
    }

    // ✅ Create multiple tasks
    @PostMapping("/create")
    public Response<List<TaskManagementDto>> createTasks(@Valid @RequestBody TaskCreateRequest request) {
        return new Response<>(taskManagementService.createTasks(request));
    }

    // ✅ Update multiple task statuses/descriptions
    @PostMapping("/update")
    public Response<List<TaskManagementDto>> updateTasks(@Valid @RequestBody UpdateTaskRequest request) {
        return new Response<>(taskManagementService.updateTasks(request));
    }

    // ✅ Reassign task (Bug Fix 1)
    @PostMapping("/assign-by-ref")
    public Response<String> assignByReference(@Valid @RequestBody AssignByReferenceRequest request) {
        return new Response<>(taskManagementService.assignByReference(request));
    }

    // ✅ Smart daily task view (Bug Fix 2 + Feature 1)
    @PostMapping("/fetch-by-date/v2")
    public Response<List<TaskManagementDto>> fetchByDate(@Valid @RequestBody TaskFetchByDateRequest request) {
        return new Response<>(taskManagementService.fetchTasksByDate(request));
    }

    // ✅ Get task by ID (includes comments and activity history)
    @GetMapping("/{id}")
    public Response<TaskManagementDto> getTaskById(@PathVariable Long id) {
        return new Response<>(taskManagementService.findTaskById(id));
    }

    // ✅ Feature 2: Update priority of a task
    @PostMapping("/update-priority")
    public Response<TaskManagementDto> updatePriority(@Valid @RequestBody UpdatePriorityRequest request) {
        return new Response<>(taskManagementService.updateTaskPriority(request));
    }

    // ✅ Feature 2: Get all tasks with a specific priority
    @GetMapping("/priority/{priority}")
    public Response<List<TaskManagementDto>> getByPriority(@PathVariable String priority) {
        return new Response<>(taskManagementService.getTasksByPriority(priority));
    }

    // ✅ Feature 3: Add a comment to a task
    @PostMapping("/comment")
    public Response<String> addComment(@RequestParam Long taskId, @RequestParam String comment) {
        taskManagementService.addComment(taskId, comment);
        return new Response<>("Comment added.");
    }
}
