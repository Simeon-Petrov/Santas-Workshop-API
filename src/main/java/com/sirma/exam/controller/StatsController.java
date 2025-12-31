package com.sirma.exam.controller;

import com.sirma.exam.dto.StatsResponse;
import com.sirma.exam.service.DeliveryService;
import com.sirma.exam.service.GiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {

    private final GiftService giftService;
    private final DeliveryService deliveryService;

    @GetMapping
    public StatsResponse getStats() {
        var giftStats = giftService.getAllGifts().stream()
                .collect(Collectors.groupingBy(g -> g.getStatus().name(), Collectors.counting()));

        return StatsResponse.builder()
                .giftsByStatus(giftStats)
                .totalDeliveries(deliveryService.getAllDeliveries().size())
                .build();
    }
}
