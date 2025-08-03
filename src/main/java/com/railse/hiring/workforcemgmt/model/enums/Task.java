package com.railse.hiring.workforcemgmt.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Task {
    ASSIGN_CUSTOMER_TO_SALES_PERSON(List.of(ReferenceType.ENTITY)),
    CREATE_INVOICE(List.of(ReferenceType.ORDER)),
    ARRANGE_PICKUP(List.of(ReferenceType.ORDER)),
    COLLECT_PAYMENT(List.of(ReferenceType.ORDER));

    private final List<ReferenceType> applicableReferenceTypes;

    Task(List<ReferenceType> applicableReferenceTypes) {
        this.applicableReferenceTypes = applicableReferenceTypes;
    }

    public List<ReferenceType> getApplicableReferenceTypes() {
        return applicableReferenceTypes;
    }

    public static List<Task> getTasksByReferenceType(ReferenceType referenceType) {
        return Arrays.stream(Task.values())
                .filter(task -> task.getApplicableReferenceTypes().contains(referenceType))
                .collect(Collectors.toList());
    }
}
