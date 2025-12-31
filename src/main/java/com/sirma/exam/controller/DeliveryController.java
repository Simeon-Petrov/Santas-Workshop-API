package com.sirma.exam.controller;

import com.sirma.exam.dto.DeliveryRequest;
import com.sirma.exam.model.Delivery;
import com.sirma.exam.model.DeliveryStatus;
import com.sirma.exam.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@Valid @RequestBody DeliveryRequest request) {
        Delivery createdDelivery = deliveryService.createDelivery(request);
        return new ResponseEntity<>(createdDelivery, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Delivery> updateStatus(
            @PathVariable Long id,
            @RequestBody java.util.Map<String, String> body) {

        DeliveryStatus newStatus = DeliveryStatus.fromString(body.get("deliveryStatus"));
        return ResponseEntity.ok(deliveryService.updateDeliveryStatus(id, newStatus));
    }
}
