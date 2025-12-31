package com.sirma.exam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DeliveryRequest {
    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 120)
    private String address;

    @NotBlank(message = "Recipient name is required")
    private String recipientName;

    @NotEmpty(message = "At least one gift ID must be provided")
    private List<Long> giftIds;

    private LocalDateTime estimatedArrival;
}
