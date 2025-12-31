package com.sirma.exam.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sun.source.tree.BreakTree;

public enum  DeliveryStatus {
    PLANNED, IN_TRANSIT, DELIVERED, FAILED;

    @JsonCreator
    public static DeliveryStatus fromString(String value) {
        if (value == null) {
            return null;
        }
        return DeliveryStatus.valueOf(value.toUpperCase().replace(" ", "_"));
    }
}
