package com.railse.hiring.workforcemgmt.model;

import lombok.Data;

@Data
public class Comment {
    private Long taskId;
    private Long timestamp;
    private String text;
}
