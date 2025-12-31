package com.sirma.exam.dto;

import com.sirma.exam.model.SkillLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ElfRequest {
    @NotBlank(message = "Elf name is required")
    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 simbols")
    private String name;

    @NotNull(message = "Skill level is required")
    private SkillLevel skillLevel;
}
