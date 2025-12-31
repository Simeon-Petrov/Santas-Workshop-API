package com.sirma.exam.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    TOY, BOOK, GADGET, CLOTHES, OTHER;

    @JsonCreator
    public static Category fromString(String value) {
       if (value == null) {
           return null;
       }
       return Category.valueOf(value.toUpperCase());
    }
}
