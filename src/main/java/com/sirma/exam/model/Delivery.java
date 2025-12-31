package com.sirma.exam.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Delivery {
    private Long id;
    private String address;
    private String recipientName;
    private List<Long> giftIds;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime estimatedArrival;
}
