package com.railse.hiring.workforcemgmt.repository;

import com.railse.hiring.workforcemgmt.model.enums.ReferenceType;
import com.railse.hiring.workforcemgmt.model.enums.Task;
import com.railse.hiring.workforcemgmt.model.enums.TaskStatus;
import com.railse.hiring.workforcemgmt.model.enums.Priority;
import com.railse.hiring.workforcemgmt.model.TaskManagement;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Long, TaskManagement> taskStore = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public InMemoryTaskRepository() {
        // Seed Data
        createSeedTask(101L, ReferenceType.ORDER, Task.CREATE_INVOICE, 1L, TaskStatus.ASSIGNED, Priority.HIGH);
        createSeedTask(102L, ReferenceType.ORDER, Task.ARRANGE_PICKUP, 1L, TaskStatus.COMPLETED, Priority.MEDIUM);
        createSeedTask(103L, ReferenceType.ORDER, Task.COLLECT_PAYMENT, 2L, TaskStatus.CANCELLED, Priority.LOW);
        createSeedTask(201L, ReferenceType.ENTITY, Task.ASSIGN_CUSTOMER_TO_SALES_PERSON, 2L, TaskStatus.ASSIGNED, Priority.LOW);
    }

    private void createSeedTask(Long refId, ReferenceType refType, Task task, Long assigneeId, TaskStatus status, Priority priority) {
        TaskManagement taskObj = new TaskManagement();
        taskObj.setId(idCounter.incrementAndGet());
        taskObj.setReferenceId(refId);
        taskObj.setReferenceType(refType);
        taskObj.setTask(task);
        taskObj.setAssigneeId(assigneeId);
        taskObj.setStatus(status);
        taskObj.setPriority(priority);
        taskObj.setDescription("Seeded task");
        taskObj.setTaskDeadlineTime(System.currentTimeMillis() + 86400000);
        taskStore.put(taskObj.getId(), taskObj);
    }

    @Override
    public Optional<TaskManagement> findById(Long id) {
        return Optional.ofNullable(taskStore.get(id));
    }

    @Override
    public TaskManagement save(TaskManagement task) {
        if (task.getId() == null) {
            task.setId(idCounter.incrementAndGet());
        }
        taskStore.put(task.getId(), task);
        return task;
    }

    @Override
    public List<TaskManagement> findAll() {
        return new ArrayList<>(taskStore.values());
    }

    @Override
    public List<TaskManagement> findByReferenceIdAndReferenceType(Long referenceId, ReferenceType referenceType) {
        return taskStore.values().stream()
                .filter(task -> task.getReferenceId().equals(referenceId)
                        && task.getReferenceType().equals(referenceType))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskManagement> findByAssigneeIdIn(List<Long> assigneeIds) {
        return taskStore.values().stream()
                .filter(task -> assigneeIds.contains(task.getAssigneeId()))
                .collect(Collectors.toList());
    }
}
