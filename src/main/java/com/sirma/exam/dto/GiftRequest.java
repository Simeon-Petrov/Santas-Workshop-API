package com.sirma.exam.dto;

import com.sirma.exam.model.Category;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftRequest {

    @NotBlank(message = "Gift name is required")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age can't be a negative number")
    @Max(value = 100, message = "Age must be to 100 years old.")
    private Integer targetAge;
}
