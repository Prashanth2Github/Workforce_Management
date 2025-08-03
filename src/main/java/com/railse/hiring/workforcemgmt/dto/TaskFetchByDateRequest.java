package com.railse.hiring.workforcemgmt.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TaskFetchByDateRequest {

    @JsonAlias({"fromDate", "startDate"})
    private Long startDate;

    @JsonAlias({"toDate", "endDate"})
    private Long endDate;

    @JsonAlias({"assigneeIds", "assignees"})
    private List<Long> assigneeIds;
}
