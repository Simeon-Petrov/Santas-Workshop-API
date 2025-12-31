package com.sirma.exam.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SkillLevel {
    JUNIOR, MID, SENIOR;

    @JsonCreator
    public  static SkillLevel fromString(String value) {
        if (value == null) {
            return null;
        }
        return SkillLevel.valueOf(value.toUpperCase());
    }
}
