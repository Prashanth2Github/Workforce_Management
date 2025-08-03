package com.railse.hiring.workforcemgmt.service.impl;

import com.railse.hiring.workforcemgmt.dto.*;
import com.railse.hiring.workforcemgmt.exception.ResourceNotFoundException;
import com.railse.hiring.workforcemgmt.mapper.ITaskManagementMapper;
import com.railse.hiring.workforcemgmt.model.Activity;
import com.railse.hiring.workforcemgmt.model.Comment;
import com.railse.hiring.workforcemgmt.model.TaskManagement;
import com.railse.hiring.workforcemgmt.model.enums.TaskStatus;
import com.railse.hiring.workforcemgmt.repository.TaskRepository;
import com.railse.hiring.workforcemgmt.service.TaskManagementService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskManagementServiceImpl implements TaskManagementService {

    private final TaskRepository taskRepository;
    private final ITaskManagementMapper taskMapper;

    // Simulated storage for comments & activities
    private final List<Comment> commentStore = new ArrayList<>();
    private final List<Activity> activityStore = new ArrayList<>();

    public TaskManagementServiceImpl(TaskRepository taskRepository, ITaskManagementMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskManagementDto> createTasks(TaskCreateRequest request) {
        if (request.getTasks() == null || request.getTasks().isEmpty()) {
            throw new IllegalArgumentException("Task list cannot be null or empty");
        }

        List<TaskManagementDto> results = new ArrayList<>();

        for (TaskCreateRequest.RequestItem item : request.getTasks()) {
            if (item.getReferenceId() == null || item.getReferenceType() == null) {
                throw new IllegalArgumentException("Reference ID and Reference Type cannot be null when creating a task");
            }

            TaskManagement task = new TaskManagement();
            task.setReferenceId(item.getReferenceId());
            task.setReferenceType(item.getReferenceType());
            task.setTask(item.getTask());
            task.setDescription(item.getDescription() != null ? item.getDescription() : "Task created");
            task.setStatus(item.getStatus() != null ? item.getStatus() : TaskStatus.ASSIGNED);
            task.setAssigneeId(item.getAssigneeId());
            task.setTaskDeadlineTime(item.getTaskDeadlineTime());
            task.setPriority(item.getPriority());

            TaskManagement saved = taskRepository.save(task);
            logActivity(saved.getId(), "Task created: " + saved.getDescription());
            results.add(taskMapper.modelToDto(saved));
        }

        return results;
    }

    @Override
    public List<TaskManagementDto> updateTasks(UpdateTaskRequest request) {
        List<TaskManagementDto> results = new ArrayList<>();

        for (UpdateTaskRequest.RequestItem item : request.getRequests()) {
            TaskManagement task = taskRepository.findById(item.getTaskId())
                    .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + item.getTaskId()));

            task.setStatus(item.getTaskStatus());
            task.setDescription(item.getDescription());

            TaskManagement saved = taskRepository.save(task);
            logActivity(saved.getId(), "Task updated to status: " + saved.getStatus());
            results.add(taskMapper.modelToDto(saved));
        }

        return results;
    }

    @Override
    public String assignByReference(AssignByReferenceRequest request) {
        List<TaskManagement> tasks = taskRepository
                .findByReferenceIdAndReferenceType(request.getReferenceId(), request.getReferenceType());

        for (TaskManagement task : tasks) {
            if (task.getAssigneeId() != null &&
                !task.getAssigneeId().equals(request.getAssigneeId()) &&
                task.getStatus() != TaskStatus.COMPLETED) {
                task.setStatus(TaskStatus.CANCELLED);
                taskRepository.save(task);
                logActivity(task.getId(), "Task cancelled due to reassignment");
            }
        }

        return "Reassignment completed. Old tasks cancelled.";
    }

    @Override
    public List<TaskManagementDto> fetchTasksByDate(TaskFetchByDateRequest request) {
        List<TaskManagement> all = taskRepository.findByAssigneeIdIn(request.getAssigneeIds());

        return taskMapper.modelListToDtoList(all.stream()
                .filter(task -> task.getStatus() != TaskStatus.CANCELLED &&
                        (
                            (task.getTaskDeadlineTime() >= request.getStartDate()
                            && task.getTaskDeadlineTime() <= request.getEndDate())
                            ||
                            (task.getTaskDeadlineTime() < request.getStartDate()
                            && task.getStatus() != TaskStatus.COMPLETED)
                        )
                ).collect(Collectors.toList()));
    }

    @Override
    public TaskManagementDto findTaskById(Long id) {
        TaskManagement task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));

        TaskManagementDto dto = taskMapper.modelToDto(task);

        return dto;
    }

    // ---------------- Feature 3 Helpers -----------------

    private void logActivity(Long taskId, String message) {
        Activity activity = new Activity();
        activity.setTaskId(taskId);
        activity.setTimestamp(System.currentTimeMillis());
        activity.setMessage(message);
        activityStore.add(activity);
    }

    public void addComment(Long taskId, String commentText) {
        Comment comment = new Comment();
        comment.setTaskId(taskId);
        comment.setTimestamp(System.currentTimeMillis());
        comment.setText(commentText);
        commentStore.add(comment);
        logActivity(taskId, "Comment added");
    }

    public List<TaskManagementDto> getTasksByPriority(String priority) {
        return taskMapper.modelListToDtoList(
            taskRepository.findAll().stream()
                .filter(task -> task.getPriority().name().equalsIgnoreCase(priority))
                .collect(Collectors.toList())
        );
    }

    public TaskManagementDto updateTaskPriority(UpdatePriorityRequest request) {
        TaskManagement task = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setPriority(request.getPriority());
        taskRepository.save(task);
        logActivity(task.getId(), "Priority updated to " + request.getPriority());
        return taskMapper.modelToDto(task);
    }
}
