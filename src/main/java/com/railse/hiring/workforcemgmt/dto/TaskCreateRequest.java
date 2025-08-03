package com.railse.hiring.workforcemgmt.dto;

import com.railse.hiring.workforcemgmt.model.enums.Priority;
import com.railse.hiring.workforcemgmt.model.enums.ReferenceType;
import com.railse.hiring.workforcemgmt.model.enums.Task;
import com.railse.hiring.workforcemgmt.model.enums.TaskStatus;
import lombok.Data;

import java.util.List;

@Data
public class TaskCreateRequest {

    private List<RequestItem> tasks;

    @Data
    public static class RequestItem {
        private Long referenceId;
        private ReferenceType referenceType;
        private Task task;
        private String description;
        private TaskStatus status;
        private Long assigneeId;
        private Priority priority;
        private Long taskDeadlineTime;
    }
}
