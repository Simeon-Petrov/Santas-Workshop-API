package com.sirma.exam.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.event.SpringApplicationEvent;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
    private Long id;

    @NotBlank(message = "Gift name can't be empty")
    private String name;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Age is required" )
    @Min(value = 0, message = "Age can't be negative number")
    @Max(value = 100, message = "Age must be to 100 years old.")
    private Integer targetAge;

    @Builder.Default
    private boolean isWrapped = false;

    @Builder.Default
    private Status status = Status.PENDING;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
