package com.railse.hiring.workforcemgmt.model;

import lombok.Data;

@Data
public class Activity {
    private Long taskId;
    private Long timestamp;
    private String message;
}
