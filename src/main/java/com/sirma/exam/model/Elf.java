package com.sirma.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Elf {
    private Long id;
    private String name;
    private SkillLevel skillLevel;

    @Builder.Default
    private List<Long> assignedGiftIds = new ArrayList<>();

}
