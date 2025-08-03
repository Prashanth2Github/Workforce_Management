package com.railse.hiring.workforcemgmt.service;

import com.railse.hiring.workforcemgmt.dto.*;

import java.util.List;

public interface TaskManagementService {

    // Create multiple tasks
    List<TaskManagementDto> createTasks(TaskCreateRequest request);

    // Update task statuses or descriptions
    List<TaskManagementDto> updateTasks(UpdateTaskRequest request);

    // Bug fix: Cancel old tasks when reassigned
    String assignByReference(AssignByReferenceRequest request);

    // Feature: Smart daily view (active within or before the date range)
    List<TaskManagementDto> fetchTasksByDate(TaskFetchByDateRequest request);

    // Feature: View task by ID (for activity and comments)
    TaskManagementDto findTaskById(Long id);

    // Feature 2: Update priority of a task
    TaskManagementDto updateTaskPriority(UpdatePriorityRequest request);

    // Feature 2: Fetch all tasks of a specific priority
    List<TaskManagementDto> getTasksByPriority(String priority);

    // Feature 3: Add a comment to a task
    void addComment(Long taskId, String commentText);
}
