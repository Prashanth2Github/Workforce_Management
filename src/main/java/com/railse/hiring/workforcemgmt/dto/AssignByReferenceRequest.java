package com.railse.hiring.workforcemgmt.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.railse.hiring.workforcemgmt.model.enums.ReferenceType;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AssignByReferenceRequest {

    @NotNull(message = "reference_id cannot be null")
    @JsonAlias({"referenceId", "refId"})
    private Long referenceId;

    @NotNull(message = "reference_type cannot be null")
    @JsonAlias({"referenceType", "refType"})
    private ReferenceType referenceType;

    @NotNull(message = "assignee_id cannot be null")
    @JsonAlias({"assigneeId", "assignedTo"})
    private Long assigneeId;
}
