package com.railse.hiring.workforcemgmt.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Response<T> {
    private T data;
    private Pagination pagination;
    private ResponseStatus status;

    public Response(T data) {
        this.data = data;
        this.status = new ResponseStatus(200, "Success");
    }

    public Response(T data, Pagination pagination, ResponseStatus status) {
        this.data = data;
        this.pagination = pagination;
        this.status = status;
    }
}
