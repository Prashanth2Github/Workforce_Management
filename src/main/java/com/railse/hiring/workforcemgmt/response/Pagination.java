package com.railse.hiring.workforcemgmt.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Pagination {
    // Optional pagination fields (not implemented in this assignment)
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
