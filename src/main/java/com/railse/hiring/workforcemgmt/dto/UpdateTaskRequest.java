package com.railse.hiring.workforcemgmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.railse.hiring.workforcemgmt.model.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateTaskRequest {

    @NotNull(message = "requests cannot be null")
    private List<RequestItem> requests;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class RequestItem {

        @NotNull(message = "task_id cannot be null")
        @JsonProperty("task_id")
        private Long taskId;

        @NotNull(message = "task_status cannot be null")
        @JsonProperty("task_status")
        private TaskStatus taskStatus;

        private String description;
    }
}
